package dsa.dp.subsequences;

import java.util.Arrays;

public class TargetSumPlusMinus {
    static int dp(int index, int arr[], int target, int[][] dpp) {

        if (index == 0) {
            return target == 0 || target == arr[index] ? 1 : 0;
        }
        if (dpp[index][target] != -1)
            return dpp[index][target];
        int notake = dp(index - 1, arr, target, dpp);
        int take = 0;
        if (arr[index] <= target) {
            take = dp(index - 1, arr, target - arr[index], dpp);
        }
        dpp[index][target] = notake + take;
        return notake + take;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int[][] dpa = new int[nums.length][target + 1];
        int total = 0;
        for (int x : nums) total += x;
        for (int[] i : dpa) {
            Arrays.fill(i, -1);
        }
        System.out.println(dp(nums.length - 1, nums, (total - target) / 2, dpa));
    }
}
