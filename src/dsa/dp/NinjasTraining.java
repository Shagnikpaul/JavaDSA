package dsa.dp;

import java.util.Arrays;
import java.util.Scanner;

public class NinjasTraining {

    public static int dp(int[][] points, int index, int type, int[][] dp) {
        if (index == 0) {
            dp[0][type] = points[0][type];
            return dp[0][type];
        }

        int c1 = 0;
        int c2 = 0;
        if (type == 0) {
            if (dp[index - 1][1] != -1)
                c1 = points[index][type] + dp[index - 1][1];
            else
                c1 = points[index][type] + dp(points, index - 1, 1, dp);
            if (dp[index - 1][2] != -1)
                c2 = points[index][type] + dp[index - 1][2];
            else
                c2 = points[index][type] + dp(points, index - 1, 2, dp);
            dp[index][type] = Math.max(c1, c2);
            return dp[index][type];
        } else if (type == 1) {
            if (dp[index - 1][0] != -1)
                c1 = points[index][type] + dp[index - 1][0];
            else
                c1 = points[index][type] + dp(points, index - 1, 0, dp);
            if (dp[index - 1][2] != -1)
                c2 = points[index][type] + dp[index - 1][2];
            else
                c2 = points[index][type] + dp(points, index - 1, 2, dp);
            dp[index][type] = Math.max(c1, c2);
            return dp[index][type];
        } else {
            if (dp[index - 1][0] != -1)
                c1 = points[index][type] + dp[index - 1][0];
            else
                c1 = points[index][type] + dp(points, index - 1, 0, dp);
            if (dp[index - 1][1] != -1)
                c2 = points[index][type] + dp[index - 1][1];
            else
                c2 = points[index][type] + dp(points, index - 1, 1, dp);
            dp[index][type] = Math.max(c1, c2);
            return dp[index][type];
        }
    }


    public static void main(String[] args) {
        int n;
        int[][] points;

        Scanner sc = new Scanner(System.in);


        int t;
        t = sc.nextInt();
        while (t > 0) {

            n = sc.nextInt();
            points = new int[n][3];
            int[][] dp = new int[n][3];
            for (int[] k : dp) {
                Arrays.fill(k, -1);
            }
            for (int i = 0; i < n; i++) {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
                points[i][2] = sc.nextInt();
            }

            dp[0][0] = points[0][0];
            dp[0][1] = points[0][1];
            dp[0][2] = points[0][2];

            for (int days = 1; days < n; days++) {
                for (int i = 0; i < 3; i++) {
                    for (int k = days - 1; k >= 0; k--) {

                    }
                }
            }
            t--;
        }
    }
}
