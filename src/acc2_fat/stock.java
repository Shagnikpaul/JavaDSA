package acc2_fat;

import java.util.Stack;

public class stock {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int[] st = {2, 3, 4, 1, 3, 5, 7, 4};
        int[] ans = new int[st.length];
        for (int i = 0; i < st.length; i++) {
            while (!s.isEmpty() && st[s.peek()] <= st[i])
                s.pop();
            if (s.isEmpty()) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - s.peek();
            }
            s.push(i);
        }
    }
}
