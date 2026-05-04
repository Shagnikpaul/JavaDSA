package acc2_fat;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapPrac {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(21, "Hello");
        hm.put(10, "Joe");
        hm.put(100, "Dope");

        TreeMap<Integer, String> tm = new TreeMap<>((a, b) -> {
            if ((a % 10) == (b % 10)) {
                return a - b;
            }
            return (a % 10) - (b % 10);
        });

        TreeMap<Integer, String> tm2 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if ((a % 10) == (b % 10)) {
                    return a - b;
                }
                return (a % 10) - (b % 10);
            }
        });
        tm2.putAll(hm);
        tm.putAll(hm);
        for (Map.Entry<Integer, String> e : tm2.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}

/*
====================== MAP OPERATIONS (HashMap + TreeMap) ======================

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {

        // Create a HashMap (unordered, fast O(1) average operations)
        Map<Integer, String> map = new HashMap<>();

        // ---------------- INSERT / UPDATE ----------------
        map.put(1, "A");              // insert key=1, value=A
        map.put(2, "B");              // insert key=2, value=B
        map.put(1, "Z");              // update key=1 (A -> Z)

        // ---------------- GET ----------------
        String val = map.get(1);      // fetch value for key=1 → "Z"
        String missing = map.get(99); // returns null if key not present

        // ---------------- REMOVE ----------------
        map.remove(2);                // removes key=2

        // ---------------- CHECK ----------------
        boolean hasKey = map.containsKey(1);     // true if key exists
        boolean hasValue = map.containsValue("Z"); // true if value exists

        // ---------------- SIZE / STATE ----------------
        int size = map.size();        // number of entries
        boolean empty = map.isEmpty();// check if map is empty

        // ---------------- ITERATION (BEST METHOD) ----------------
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        } // gives both key and value efficiently

        // ---------------- KEY ONLY ----------------
        for (Integer k : map.keySet()) {
            System.out.println(k);   // iterate only keys
        }

        // ---------------- VALUE ONLY ----------------
        for (String v : map.values()) {
            System.out.println(v);   // iterate only values
        }

        // ---------------- JAVA 8 METHODS ----------------
        map.putIfAbsent(3, "C");     // insert only if key not present
        String def = map.getOrDefault(4, "Default"); // avoids null

        map.replace(1, "X");         // replace value for key=1
        map.replace(1, "X", "Y");    // replace only if old value matches

        map.forEach((k, v) -> System.out.println(k + " " + v)); // lambda iteration

        // ---------------- COMPUTE / MERGE ----------------
        map.compute(1, (k, v) -> (v == null) ? "New" : v + "X"); // update with logic

        map.computeIfAbsent(5, k -> "E"); // add if key missing

        map.computeIfPresent(1, (k, v) -> v + "Y"); // update if key exists

        map.merge(1, "M", (oldVal, newVal) -> oldVal + newVal); // combine values

        // ---------------- TREE MAP (SORTED) ----------------
        Map<Integer, String> tm = new TreeMap<>(); // sorted ascending by key
        tm.put(3, "C");
        tm.put(1, "A");
        tm.put(2, "B");

        // ---------------- TREE MAP WITH CUSTOM COMPARATOR ----------------
        Map<Integer, String> tmDesc =
            new TreeMap<>((a, b) -> Integer.compare(b, a)); // descending order

        tmDesc.putAll(map); // copy all entries from HashMap into TreeMap

        // ---------------- CLEAR ----------------
        map.clear();        // removes all entries

        // =========================================================================
        // QUICK SUMMARY:
        // put → add/update
        // get → retrieve value
        // remove → delete entry
        // containsKey → fast lookup
        // entrySet → best iteration
        // TreeMap → sorted map (log n operations)
        // =========================================================================
    }
}
*/