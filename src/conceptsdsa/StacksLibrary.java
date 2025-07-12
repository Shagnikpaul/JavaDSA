package conceptsdsa;

import java.util.Stack;

public class StacksLibrary {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(12);

        s.push(23);

        s.push(232);

        System.out.printf("Top of the stack is %d \n", s.peek());

        for (Integer i : s) {
            System.out.println(i);
        }
    }
}
