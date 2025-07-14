package dsa.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int nums[] = { 1, 2 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                hm.put(nums[i], 1);
            }

            if (hm.get(nums[i]) > Math.floor(nums.length / 3)) {
                if (!ls.contains(nums[i])) {
                    ls.add(nums[i]);
                }
            }
        }

        System.out.println(ls.toString());
    }
}
