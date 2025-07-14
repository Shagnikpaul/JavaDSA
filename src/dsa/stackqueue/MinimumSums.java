package dsa.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class MinimumSums {

    public static int[] nse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = arr.length;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }
        return ans;
    }

    public static int[] pse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 4 };

        int mod = (int) Math.pow(10, 9) + 7;

        int nse[] = nse(arr);
        int pse[] = pse(arr);

        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            total = (total + (right * left * arr[i]) % mod) % mod;
        }
        System.out.println("Total = " + total);
        System.out.println(Arrays.toString(nse(arr)));
        System.out.println(Arrays.toString(pse(arr)));
    }

}
