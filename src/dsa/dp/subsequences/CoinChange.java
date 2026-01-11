package dsa.dp.subsequences;


import java.util.Arrays;

public class CoinChange {

    public static int dp(int[] coins, int index, int amount, int[][] dpa) {

        if (amount == 0)
            return 0;
        if (index == 0) {
            if (amount % coins[index] == 0) {
                dpa[index][amount] = amount / coins[index];
            } else {
                dpa[index][amount] = Integer.MAX_VALUE;
            }
            return dpa[index][amount];
        }
        if (dpa[index][amount] != -1) {
            return dpa[index][amount];
        }
        int countIfTake = Integer.MAX_VALUE;

        if (coins[index] <= amount) {
            int k = dp(coins, index, amount - coins[index], dpa);
            countIfTake = (k == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + k);

        }
        int noTake = dp(coins, index - 1, amount, dpa);
        dpa[index][amount] = Math.min(countIfTake, noTake);
        //System.out.println("For amount : " + amount + " For coin " + coins[index] + " took " + dpa[index][amount]);
        return dpa[index][amount];
    }

    public static void main(String[] args) {
        int[] coins = {3, 7, 405, 436};
        int amount = 8839;
        int[][] dpa = new int[coins.length][amount + 1];
        for (int[] x : dpa) {
            Arrays.fill(x, -1);
        }
        System.out.println("COins needed  : " + dp(coins, coins.length - 1, amount, dpa));

    }
}
