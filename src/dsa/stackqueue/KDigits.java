package dsa.stackqueue;

import java.util.Stack;

public class KDigits {
    public static void main(String[] args) {
        String num = "10";
        Stack<Character> st = new Stack<>();

        int k = 1;

        for (int i = 0; i < num.length(); i++) {

            // if top of the stack has a larger number then that will result in a larger
            // overall number so removing it is the best choice...

            while (!st.isEmpty() && k > 0 && (st.peek() - '0') > (num.charAt(i) - '0')) {
                st.pop();
                k--;
            }

            st.push(num.charAt(i));
        }

        // handle edge cases
        // say all digits were removed
        if (st.isEmpty()) {
            System.out.println("0");
            return;
        }

        // say no digit was removed since all digits were in increasing order then
        // remove k digits from the back

        while (k > 0) {
            st.pop();
            k--;
        }
        if (st.isEmpty()) {
            System.out.println("0");
            return;
        }
        String res = "";
        while (!st.isEmpty()) {
            res += st.pop();
        }
        // if (res == "0")
        //     return res;
        int j = res.length() - 1;
        while (res.charAt(j) == '0') {
            j--;
        }

        System.out.println(new StringBuilder(res.substring(0, j + 1)).reverse().toString());
    }
}
