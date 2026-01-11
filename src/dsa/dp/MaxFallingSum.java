package dsa.dp;

import java.util.Arrays;

public class MaxFallingSum {
    public int find(int[][] matrix, int level, int index, int[][] dp) {
        if (dp[level][index] != -1) {
            return dp[level][index];
        }
        if (level == 0) {
            dp[level][index] = matrix[level][index];
            return dp[level][index];
        }

        int one = Integer.MAX_VALUE;
        int two;
        int three = Integer.MAX_VALUE;

        if (index - 1 >= 0) {
            if (dp[level - 1][index - 1] != -1)
                one = matrix[level][index] + dp[level - 1][index - 1];
            else
                one = matrix[level][index] + find(matrix, level - 1, index - 1, dp);
        }
        if (dp[level - 1][index] != -1)
            two = matrix[level][index] + dp[level - 1][index];
        else
            two = matrix[level][index] + find(matrix, level - 1, index, dp);
        if (index + 1 < matrix.length) {
            if (dp[level - 1][index + 1] != -1)
                three = matrix[level][index] + dp[level - 1][index + 1];
            else
                three = matrix[level][index] + find(matrix, level - 1, index + 1, dp);
        }

        dp[level][index] = Math.min(one, Math.min(two, three));
        return dp[level][index];

    }

    public int minFallingPathSum(int[][] matrix) {
        int c = 100000;
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        for (int i = 0; i < n; i++) {
            c = Math.min(c, find(matrix, n - 1, i, dp));
        }
        return c;
    }

    public static void main(String[] args) {
        MaxFallingSum s = new MaxFallingSum();
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
//        int[][] matrix = {
//                {-19, 57},
//                {-40, -5}
//        };

        System.out.println("Ans = " + s.minFallingPathSum(matrix));
    }
}
