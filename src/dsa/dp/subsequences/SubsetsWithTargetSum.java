package dsa.dp.subsequences;

import java.util.Arrays;

public class SubsetsWithTargetSum {
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
        int[] arr = {4, 3, 5, 2};
        int target = 6;
        int[][] dpa = new int[arr.length][target + 1];
        for (int[] i : dpa) {
            Arrays.fill(i, -1);
        }
        System.out.println("Can we achieve it? " + dp(arr.length - 1, target, arr, dpa));

    }
}
