package dsa.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 1 };

        int ans[] = new int[nums.length];

        Stack<Integer> st = new Stack<>();

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i % nums.length] >= st.peek()) {
                st.pop();
            }

            if (i < nums.length) {
                ans[i] = (st.isEmpty()) ? -1 : st.peek();
            }

            st.push(nums[i % nums.length]);
        }

        System.out.println(Arrays.toString(ans));

    }
}
