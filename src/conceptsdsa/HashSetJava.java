package conceptsdsa;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetJava {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        // wont guarantee order of elements
        hashSet.add("null");
        hashSet.add("nul2");
        hashSet.add("null3");
        hashSet.add("null");
        hashSet.add("null");

        Set<String> set = new LinkedHashSet<>();

        set.add("null");
        set.add("null");
        set.add("null");
        set.add("null2");
        set.add("nul3");
        set.add("null");
        set.add("null");
        set.add("null");

        System.out.println(hashSet.toString());
        System.out.println(set.toString());
    }
}
