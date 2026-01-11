package dsa.dp.subsequences;

import java.util.Arrays;

public class PartitionEqualSubset {
    static boolean dp(int[] arr, int cur, int total, int index, int[][] memo) {
        System.out.println("Current sum = " + cur);
        if (cur == (total - cur)) {
            System.out.println("Found !!");
            memo[index][cur] = 1;
            return true;
        }
        if (memo[index][cur] != -1) {
            return (memo[index][cur] == 1);
        }
        if (index == 0) {
            memo[0][cur] = arr[0] == (total - arr[0]) ? 1 : 0;
            return arr[0] == (total - arr[0]);
        }

        boolean take = false;
        boolean notake = false;
        if (memo[index - 1][cur + arr[index]] == -1)
            take = dp(arr, cur + arr[index], total, index - 1, memo);
        else
            take = memo[index - 1][cur + arr[index]] == 1;
        if (memo[index - 1][cur] == -1)
            notake = dp(arr, cur, total, index - 1, memo);
        else
            notake = memo[index - 1][cur] == 1;
        memo[index][cur] = take | notake ? 1 : 0;
        return take | notake;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1};
        int total = 0;
        for (int x : nums) total += x;
        int[][] memo = new int[nums.length + 1][total];
        for (int[] x : memo) Arrays.fill(x, -1);
        System.out.println("Result : " + dp(nums, 0, total, nums.length - 1, memo));

    }
}
