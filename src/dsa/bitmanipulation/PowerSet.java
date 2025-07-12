package dsa.bitmanipulation;

import java.util.ArrayList;

public class PowerSet {

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        ArrayList<ArrayList<Integer>> lis = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            ArrayList<Integer> li = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // System.out.println("(i & (1 << j)) = " + (i & (1 << j)));
                if ((i & (1 << j)) != 0) {
                    li.add(nums[j]);
                }
            }
            lis.add(li);
        }
        System.out.println(lis.toString());
    }
}