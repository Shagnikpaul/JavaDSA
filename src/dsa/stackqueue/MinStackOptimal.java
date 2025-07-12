
package dsa.stackqueue;

import java.util.Stack;

public class MinStackOptimal {
    public static void main(String[] args) {

    }
}
class MinStack {
    Stack<Integer> st;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        this.st = new Stack<>();

    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(val);
            min = val;
        } else if (val < min) {
            st.push(2 * val - min);
            min = val;
        } else {
            st.push(val);
        }
    }

    public void pop() {
        if (st.isEmpty())
            return;
        int x = st.pop();
        if (x < min) {
            min = 2 * min - x;
        }

    }

    public int top() {
        if (st.isEmpty())
            return -1;
        int x = st.peek();
        if (x < min)
        return min;
        return x;
    }

    public int getMin() {
        return min;
    }
}