package hackathon;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class TypeScript {
    public static void main(String[] args) throws Exception {
        Solution.main();
    }
}


class Solution {
    static class Schema {
        boolean seenString;
        boolean seenNumber;
        boolean seenBoolean;
        boolean seenNull;
        boolean seenObject;
        ObjectSchema objectSchema;
        boolean seenArray;
        Schema arrayElementSchema;
    }

    static class ObjectSchema {

        Map<String, FieldInfo> fields = new TreeMap<>();
        int totalObjectsSeen;
        String baseName;
        String finalName;
        ObjectSchema parent;
        String keyFromParent;

        ObjectSchema(String baseName) {
            this.baseName = baseName;
        }
    }

    static class FieldInfo {

        Schema schema = new Schema();
        int presenceCount;
    }

    static ObjectSchema createObjectSchema(
            String key,
            ObjectSchema parent
    ) {
        ObjectSchema os =
                new ObjectSchema(capitalize(key));
        os.parent = parent;
        os.keyFromParent = key;
        return os;
    }

    /**
     * used for
     * address -> Address
     * userProfile -> UserProfile
     * my_field -> My_field
     */
    static String capitalize(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    static String getUniqueName(
            String base,
            Set<String> used
    ) {
        if (!used.contains(base)) {
            return base;
        }
        int suffix = 2;
        while (used.contains(base + suffix)) {
            suffix++;
        }
        return base + suffix;
    }

    static void assignSchema(
            Schema schema,
            Set<String> used
    ) {
        if (schema.seenObject) {
            ObjectSchema child =
                    schema.objectSchema;
            if (child.finalName == null) {
                child.finalName =
                        getUniqueName(
                                child.baseName,
                                used
                        );
                used.add(child.finalName);
                assignNested(child, used);
            }
        }
        if (schema.seenArray) {
            assignSchema(
                    schema.arrayElementSchema,
                    used
            );
        }
    }

    static void assignNested(
            ObjectSchema os,
            Set<String> used
    ) {

        for (String key : os.fields.keySet()) {

            FieldInfo field = os.fields.get(key);

            Schema schema = field.schema;

            assignSchema(schema, used);
        }
    }

    static void assignNames(ObjectSchema root) {

        Set<String> used = new HashSet<>();
        used.add(root.baseName);
        root.finalName = root.baseName;
        assignNested(root, used);
    }

    static void mergeObject(ObjectSchema os, JSONObject jo) {
        os.totalObjectsSeen++;
        for (String key : jo.keySet()) {
            FieldInfo field = os.fields.get(key);
            if (field == null) {
                field = new FieldInfo();
                os.fields.put(key, field);
            }
            field.presenceCount++;
            Object value = jo.get(key);
            mergeIntoSchema(
                    field.schema,
                    value,
                    key,
                    os
            );
        }
    }

    static void mergeIntoSchema(
            Schema schema,
            Object value,
            String keyName,
            ObjectSchema parent
    ) {

        if (value == JSONObject.NULL) {
            schema.seenNull = true;
        } else if (value instanceof String) {
            schema.seenString = true;
        } else if (value instanceof Number) {
            schema.seenNumber = true;
        } else if (value instanceof Boolean) {
            schema.seenBoolean = true;
        } else if (value instanceof JSONObject jo) {

            schema.seenObject = true;

            if (schema.objectSchema == null) {
                schema.objectSchema =
                        createObjectSchema(keyName, parent);
            }

            mergeObject(schema.objectSchema, jo);
        } else if (value instanceof JSONArray arr) {
            schema.seenArray = true;
            if (schema.arrayElementSchema == null) {
                schema.arrayElementSchema = new Schema();
            }
            for (int i = 0; i < arr.length(); i++) {
                Object element = arr.get(i);
                mergeIntoSchema(
                        schema.arrayElementSchema,
                        element,
                        keyName,
                        parent
                );
            }
        }
    }

    static void printSchema(Schema s, int depth) {

        String indent = "  ".repeat(depth);
        if (s.seenString)
            System.out.println(indent + "string");
        if (s.seenNumber)
            System.out.println(indent + "number");
        if (s.seenBoolean)
            System.out.println(indent + "boolean");
        if (s.seenNull)
            System.out.println(indent + "null");
        if (s.seenObject) {
            System.out.println(indent + "object");
            printObject(s.objectSchema, depth + 1);
        }
        if (s.seenArray) {
            System.out.println(indent + "array");
            printSchema(s.arrayElementSchema, depth + 1);
        }
    }


    static void printObject(ObjectSchema os, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "OBJECT");
        for (String key : os.fields.keySet()) {
            FieldInfo field = os.fields.get(key);
            System.out.println(
                    indent + key
                            + " present="
                            + field.presenceCount
            );
            printSchema(field.schema, depth + 1);
        }
    }


    static String getArrayTypeString(
            Schema elementSchema
    ) {

        ArrayList<String> types =
                new ArrayList<>();

        if (elementSchema.seenBoolean) {
            types.add("boolean");
        }

        if (elementSchema.seenNull) {
            types.add("null");
        }

        if (elementSchema.seenNumber) {
            types.add("number");
        }

        if (elementSchema.seenString) {
            types.add("string");
        }

        if (elementSchema.seenObject) {
            types.add(
                    elementSchema.objectSchema.finalName
            );
        }

        Collections.sort(types);

        if (types.isEmpty()) {
            return "unknown[]";
        }

        if (types.size() == 1) {
            return types.get(0) + "[]";
        }

        return "("
                + String.join(" | ", types)
                + ")[]";
    }

    static String getTypeString(Schema schema) {

        ArrayList<String> types =
                new ArrayList<>();

        if (schema.seenBoolean) {
            types.add("boolean");
        }

        if (schema.seenNull) {
            types.add("null");
        }

        if (schema.seenNumber) {
            types.add("number");
        }

        if (schema.seenString) {
            types.add("string");
        }

        if (schema.seenObject) {
            types.add(
                    schema.objectSchema.finalName
            );
        }

        if (schema.seenArray) {

            String arrType =
                    getArrayTypeString(
                            schema.arrayElementSchema
                    );

            types.add(arrType);
        }

        Collections.sort(types);

        return String.join(" | ", types);
    }

    static void collectInterfaces(
            ObjectSchema os,
            Map<String, ObjectSchema> all
    ) {

        if (all.containsKey(os.finalName)) {
            return;
        }

        all.put(os.finalName, os);

        for (String key : os.fields.keySet()) {

            Schema s = os.fields.get(key).schema;

            if (s.seenObject) {

                collectInterfaces(
                        s.objectSchema,
                        all
                );
            }

            if (s.seenArray &&
                    s.arrayElementSchema.seenObject) {

                collectInterfaces(
                        s.arrayElementSchema.objectSchema,
                        all
                );
            }
        }
    }

    static String emitInterface(
            ObjectSchema os
    ) {

        if (os.fields.isEmpty()) {
            return "export interface "
                    + os.finalName
                    + " {}";
        }

        StringBuilder sb =
                new StringBuilder();

        sb.append("export interface ")
                .append(os.finalName)
                .append(" {\n");

        for (String key : os.fields.keySet()) {

            FieldInfo field =
                    os.fields.get(key);

            boolean optional =
                    field.presenceCount
                            < os.totalObjectsSeen;

            sb.append("  ")
                    .append(key);

            if (optional) {
                sb.append("?");
            }

            sb.append(": ")
                    .append(
                            getTypeString(
                                    field.schema
                            )
                    )
                    .append(";\n");
        }

        sb.append("}");

        return sb.toString();
    }

    static String solve(String rootName, String jsonText) {

        JSONArray arr = new JSONArray(jsonText);

        ObjectSchema root =
                new ObjectSchema(rootName);

        root.finalName = rootName;

        for (int i = 0; i < arr.length(); i++) {

            JSONObject jo =
                    arr.getJSONObject(i);

            mergeObject(root, jo);
        }

        assignNames(root);

        Map<String, ObjectSchema> all =
                new TreeMap<>();

        collectInterfaces(root, all);

        StringBuilder out =
                new StringBuilder();

        boolean first = true;

        for (ObjectSchema os : all.values()) {

            if (!first) {
                out.append("\n\n");
            }

            first = false;

            out.append(emitInterface(os));
        }

        return out.toString();
    }

    public static void main() throws Exception {
        //System.out.println(System.getProperty("user.dir"));
        BufferedReader in = new BufferedReader(
                new FileReader("LearningJava/src/hackathon/input.txt")
        );

        int t = Integer.parseInt(in.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String rootName = in.readLine();
            String jsonText = in.readLine();

            if (i > 0)
                sb.append("\n---\n");

            sb.append(solve(rootName, jsonText));
        }

        sb.append('\n');

        System.out.print(sb);
    }
}