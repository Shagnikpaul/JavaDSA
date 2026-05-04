package acc2_fat;

import java.util.Stack;

public class checkStack {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        Stack<Integer> a = new Stack<>();
        //Stack<Integer> b = new Stack<>();

        int[] aa = new int[3];
        int[] bb = new int[3];

        while (i < 3) {
            a.push(aa[i]);
            i++;
            while (!a.isEmpty() && j < 3 && a.peek() == bb[j]) {
                a.pop();
                j++;
            }

        }
    }
}
