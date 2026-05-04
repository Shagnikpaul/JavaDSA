package acc2_fat;

import java.util.Stack;

public class celebrity {
    public static void main(String[] args) {
        int[][] knows = {
                {0, 1, 1},
                {0, 0, 1},
                {0, 0, 0}
        };
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < knows.length; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int a = st.peek();
            st.pop();
            int b = st.peek();
            st.pop();
            if (knows[a][b] == 1) {
                st.push(b);
            } else {
                st.push(a);
            }
        }
        System.out.println("asn = " + st.peek());
    }
}
