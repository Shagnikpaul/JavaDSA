/*
====================== SET OPERATIONS (HashSet, TreeSet, LinkedHashSet) ======================

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {

        // ====================== HASHSET ======================
        // Unordered, no duplicates, O(1) average operations
        // null allowed
        Set<Integer> hs = new HashSet<>();

        hs.add(3);              // add element
        hs.add(1);
        hs.add(2);
        hs.add(1);              // duplicate ignored

        hs.remove(2);           // remove element

        boolean has = hs.contains(1); // check existence

        int size = hs.size();   // number of elements
        boolean empty = hs.isEmpty(); // check if empty

        for (int x : hs) {      // iteration (no order)
            System.out.println(x);
        }

        hs.clear();             // remove all elements


        // ====================== LINKEDHASHSET ======================
        // Maintains insertion order
        Set<Integer> lhs = new LinkedHashSet<>();

        lhs.add(3);             // insertion order preserved
        lhs.add(1);
        lhs.add(2);

        for (int x : lhs) {     // prints in insertion order: 3,1,2
            System.out.println(x);
        }


        // ====================== TREESET ======================
        // Sorted set (ascending by default), O(log n)
        Set<Integer> ts = new TreeSet<>();

        ts.add(3);
        ts.add(1);
        ts.add(2);              // stored as: 1,2,3 (sorted)

        // Custom comparator (descending order)
        Set<Integer> tsDesc =
            new TreeSet<>((a, b) -> Integer.compare(b, a));

        tsDesc.addAll(ts);      // copy elements

        for (int x : tsDesc) {  // prints: 3,2,1
            System.out.println(x);
        }


        // ====================== COMMON SET OPERATIONS ======================

        Set<Integer> A = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> B = new HashSet<>(Arrays.asList(2, 3, 4));

        // Union (A ∪ B)
        Set<Integer> union = new HashSet<>(A);
        union.addAll(B);        // {1,2,3,4}

        // Intersection (A ∩ B)
        Set<Integer> intersection = new HashSet<>(A);
        intersection.retainAll(B); // {2,3}

        // Difference (A - B)
        Set<Integer> diff = new HashSet<>(A);
        diff.removeAll(B);      // {1}


        // ====================== JAVA 8 METHODS ======================

        hs.forEach(x -> System.out.println(x)); // lambda iteration


        // =========================================================================
        // QUICK SUMMARY:
        // HashSet → fast, no order
        // LinkedHashSet → insertion order
        // TreeSet → sorted order (log n)
        // add → insert
        // remove → delete
        // contains → search
        // =========================================================================
    }
}
*/


package acc2_fat;

import java.util.*;

public class SetPrac {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(21);
        s.add(221);
        s.add(21);
        s.add(10);

//        s.forEach((x) -> {
//            System.out.println("Joe : " + x);
//        });

        Set<Integer> or = new TreeSet<>();
        or.addAll(s);
        or.forEach((x) -> {
            System.out.println("Joe or : " + x);
        });
        Set<Integer> a = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> b = new LinkedHashSet<>(Arrays.asList(3, 4, 5));
        // a-b
        a.removeAll(b);
        System.out.println("intersection : " + a);

    }
}
