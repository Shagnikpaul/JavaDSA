package dsa.dp;

import java.util.Arrays;

public class FrogJump1 {
    static int[] dp;

    public static int minJump(int n, int[] heights) {
        //System.out.println("Runnign for " + n);
        if (n == 0) {
            return 0;
        }
        if (dp[n] == -1) {
            int l;
            int r = Integer.MAX_VALUE;
            l = minJump(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
            if (n > 1) {
                r = minJump(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
            }
            dp[n] = Math.min(l, r);
        }
        return dp[n];

    }

    public static void main(String[] args) {
        int[] heights = {7, 5, 1, 2, 6};
        dp = new int[heights.length + 1];
        Arrays.fill(dp, -1);
       
        int x = minJump(heights.length - 1, heights);
        System.out.println("Min Jump E = " + x);
    }
}
