package acc2_fat;

import java.util.Stack;

public class hanoi {
    public static void move(Stack<Integer> src, Stack<Integer> dest, char s, char d) {
        if (src.isEmpty()) {
            src.push(dest.pop());
            System.out.println("Moved from " + d + " -> " + s);
        } else if (dest.isEmpty()) {
            dest.push(src.pop());
            System.out.println("Moved from " + s + " -> " + d);
        } else if (src.peek() < dest.peek()) {
            dest.push(src.pop());
            System.out.println("Moved from " + s + " -> " + d);
        } else {
            src.push(dest.pop());
            System.out.println("Moved from " + d + " -> " + s);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> src = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        Stack<Integer> dest = new Stack<>();

        int n = 3;
        for (int i = n; i >= 1; i--) {
            src.push(i);
        }
        int moves = (int) Math.pow(2, n) - 1;
        for (int i = 1; i <= moves; i++) {
            if (i % 3 == 1) {
                move(src, dest, 'a', 'c');
            } else if (i % 3 == 2) {
                move(src, aux, 'a', 'b');
            } else {
                move(aux, dest, 'b', 'c');
            }
        }
    }
}
