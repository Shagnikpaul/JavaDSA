package dsa.arrays;

import java.util.Arrays;

public class CountInversions {
    static int c = 0;


    public static void merge(int l, int r, int[] arr) {
        int m = (r + l) / 2;
        int[] le = new int[m - l + 1];
        int[] ri = new int[r - m];

        for (int i = 0; i < m - l + 1; i++) {
            le[i] = arr[i + l];
        }

        for (int i = 0; i < r - m; i++) {
            ri[i] = arr[i + m + 1];
        }
        int i = 0;
        int j = 0;
        int k = l;

        while (i < (m - l + 1) && j < (r - m)) {
            if (le[i] <= ri[j]) {
                arr[k++] = le[i++];
            } else {
                c += (m - i + 1 - l);
                arr[k++] = ri[j++];
            }
        }

        while (i < (m - l + 1)) {
            arr[k++] = le[i++];
        }

        while (j < (r - m)) {
            arr[k++] = ri[j++];
        }
    }

    public static void mergeS(int l, int r, int[] arr) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeS(l, m, arr);
        mergeS(m + 1, r, arr);
        merge(l, r, arr);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        mergeS(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(c);
    }
}
