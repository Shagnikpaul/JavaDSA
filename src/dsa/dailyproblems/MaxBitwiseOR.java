package dsa.dailyproblems;

import java.util.ArrayList;

public class MaxBitwiseOR {
    public static void main(String[] args) {

        int nums[] = { 3, 2, 1, 5 };
        int count = 0;
        int maxOr = 0;
        for (int i : nums) {
            maxOr |= i;
        }
        // System.out.println("Max OR " + maxOr);

        for (int i = 0; i < (1 << nums.length); i++) {

            int cOr = 0;
            for (int j = 0; j < nums.length; j++) {
                // System.out.println("(i & (1 << j)) = " + (i & (1 << j)));

                if ((i & (1 << j)) != 0) {
                    cOr |= nums[j];
                }
            }
            if (cOr == maxOr) {
                count++;
            }
        }
        System.out.println("Count = " + count);
    }
}
