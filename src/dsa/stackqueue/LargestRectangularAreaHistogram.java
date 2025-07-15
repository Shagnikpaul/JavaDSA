package dsa.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangularAreaHistogram {

    public static int[] pse(int nums[]) { // PSEE not PSE
        int pse[] = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty())
                pse[i] = -1;
            else
                pse[i] = st.peek();

            st.push(i);
        }

        return pse;
    }

    public static int[] nse(int nums[]) {
        int nse[] = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            if (st.isEmpty())
                nse[i] = nums.length;
            else
                nse[i] = st.peek();

            st.push(i);
        }
        return nse;
    }

    public static void main(String[] args) {
        int heights[] = { 1, 1 };
        int pse[] = pse(heights);
        int nse[] = nse(heights);
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int k = (nse[i] - pse[i] - 1) * heights[i];
            if (k > maxArea)
                maxArea = k;
        }
        System.out.println("max = " + maxArea);
        System.out.println(Arrays.toString(pse(heights)));
        System.out.println(Arrays.toString(nse(heights)));
    }
}
