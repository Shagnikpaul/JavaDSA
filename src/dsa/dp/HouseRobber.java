package dsa.dp;

import java.util.Arrays;

public class HouseRobber {
    int[] dp;

    public int rob(int n, int[] arr) {
        if (n == 0) {
            dp[0] = arr[0];
            return arr[0];
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1)
            return dp[n];

        int l, r;
        if (dp[n - 1] != -1) {
            l = dp[n - 1];
        } else {
            l = 0 + rob(n - 1, arr);
        }
        if (n > 1) {
            if (dp[n - 2] != -1) {
                r = arr[n] + dp[n - 2];
            } else {
                r = arr[n] + rob(n - 2, arr);
            }
        } else {
            r = arr[n] + rob(n - 2, arr);
        }
        dp[n] = Math.max(l, r);
        System.out.println("Calc " + dp[n]);
        return dp[n];

    }


    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        int[] nums = {1, 2};
        h.dp = new int[nums.length];
        Arrays.fill(h.dp, -1);
        System.out.println("Max rob : " + h.rob(nums.length - 1, nums));
    }
}
