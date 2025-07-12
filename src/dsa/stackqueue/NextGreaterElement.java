package dsa.stackqueue;

import java.util.Arrays;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Integer nums1[] = { 4, 1, 2 };
        Integer nums2[] = { 1, 3, 4, 2 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums2.length];

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek();

            st.push(nums2[i]);
        }
        int kans[] = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            kans[i] = ans[map.get(nums1[i])];
        }

        System.out.println(Arrays.toString(kans));
    }
}
