package acc2_fat;

import java.util.Stack;

public class minstack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> minSt = new Stack<>();
        minSt.push(Integer.MAX_VALUE);

        /// push func
        int x = 3;
        st.push(x);
        if (x < minSt.peek()) {
            minSt.push(x);
        }

        // remove
        int s = st.pop();
        if (minSt.peek() == s) {
            minSt.pop();
        }
    }
}
