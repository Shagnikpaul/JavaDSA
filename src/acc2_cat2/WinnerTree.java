package acc2_cat2;

import java.util.Arrays;

public class WinnerTree {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1000};
        int n = arr.length;
        int[] tree = new int[arr.length * 2];
        for (int i = n; i < 2 * n; i++) {
            tree[i] = i - n;
        }
        for (int i = n - 1; i > 0; i--) {
            int l = i * 2;
            int r = i * 2 + 1;
            tree[i] = (arr[tree[l]] < arr[tree[r]]) ? tree[l] : tree[r];
        }
        System.out.println("Loser : " + tree[1] + " with score : " + arr[tree[1]]);
    }
}
