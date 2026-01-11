package dsa.dp.subsequences;

import java.util.Arrays;

public class EqualPartitionWithMinAbsDiff {
    static int total = 0;

    static int dp(int index, int target, int[] arr, int[][] dpp) {
        if (dpp[index][target] != -1)
            return dpp[index][target];
        if (index == 0) {
            dpp[index][target] = (target == arr[0]) ? 1 : 0;

            return dpp[index][target];
        }

        if (target == 0) {

            dpp[index][0] = 1;
            return dpp[index][0];
        }


        boolean nottake = false;
        if (dpp[index - 1][target] != -1) {
            nottake = dpp[index - 1][target] == 1;
        } else {
            nottake = dp(index - 1, target, arr, dpp) == 1;
        }
        boolean take = false;
        if (arr[index] < target) {
            if (dpp[index - 1][target - arr[index]] != -1) {
                take = dpp[index - 1][target - arr[index]] == 1;
            } else
                take = dp(index - 1, target - arr[index], arr, dpp) == 1;
        }
        dpp[index][target] = (nottake | take) ? 1 : 0;

        return dpp[index][target];
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 7, 3};
        int t = 0;
        for (int x : arr) {
            t += x;
        }
        total = t;
        int target = t;
        int[][] dpa = new int[arr.length][target + 1];
        for (int[] i : dpa) {
            Arrays.fill(i, -1);
        }

        for (int i = 0; i <= total; i++) {
            dp(arr.length - 1, i, arr, dpa);
        }
        int mn = Integer.MAX_VALUE;
//        for (int i = 0; i < dpa.length; i++) {
//            for (int j = 0; j < target + 1; j++) {
//                System.out.print(dpa[i][j] + " ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i <= t; i++) {
            if (dpa[arr.length - 1][i] == 1) {
                //System.out.println(Math.abs((t - i) - (i)));
                mn = Math.min(mn, Math.abs((t - i) - (i)));
            }
        }
        System.out.println("Min = " + mn);
    }
}
