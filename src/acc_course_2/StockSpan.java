package acc_course_2;

import java.util.Stack;

public class StockSpan {

    static void span(int[] price) {
        Stack<Integer> s = new Stack<>();
        int[] span = new int[price.length];

        for (int i = 0; i < price.length; i++) {
            while (!s.isEmpty() && price[s.peek()] <= price[i])
                s.pop();
            span[i] = s.isEmpty() ? i + 1 : i - s.peek();
            s.push(i);
        }

        for (int x : span)
            System.out.print(x + " ");
    }

    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75, 85};
        span(price);
    }
}

