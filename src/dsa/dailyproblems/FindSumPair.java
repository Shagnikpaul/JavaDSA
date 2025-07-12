package dsa.dailyproblems;

import java.util.Hashtable;

public class FindSumPair {
    public static void main(String[] args) {
        int nums1[] = { 1, 1, 2, 2, 2, 3 };
        int nums2[] = { 1, 4, 5, 2, 5, 4 };

        int tot = 7;
        int c = 0;

        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for (int i = 0; i < nums2.length; i++) {
            if (ht.containsKey(nums2[i])) {
                ht.put(nums2[i], (ht.get(nums2[i]) + 1));
            } else {
                ht.put(nums2[i], 1);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            if (ht.containsKey(tot - nums1[i])) {
                c += ht.get(tot - nums1[i]);
            }
        }
        System.out.println("Count = " + c);
    }

}
