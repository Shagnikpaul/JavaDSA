package acc_course_2;

import java.util.Stack;

public class IterativeTowerHanoi {

    public static void solve(Stack<Integer> src, Stack<Integer> dest) {
        if (src.isEmpty() || (!dest.isEmpty() && dest.peek() < src.peek())) {
            src.push(dest.pop());
        } else {
            dest.push(src.pop());
        }
    }


    public static void main(String[] args) {
        int n = 3;
        Stack<Integer> src = new Stack<>();
        Stack<Integer> dest = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        int moves = (int) Math.pow(2, n) - 1;
        for (int i = n; i >= 1; i--) {
            src.push(i);
        }
        for (int i = 1; i <= moves; i++) {
            if (i % 3 == 1) {
                solve(src, dest);
            } else if (i % 3 == 2) {
                solve(src, aux);
            } else {
                solve(aux, dest);
            }
        }
        System.out.println(dest.peek());
    }
}
