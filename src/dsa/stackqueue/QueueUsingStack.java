package dsa.stackqueue;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {

    }
}

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        for (int i = 1; i <= s1.size(); i++)
            s2.push(s1.pop());
        s1.push(x);
        for (int i = 1; i <= s2.size(); i++)
            s1.push(s2.pop());
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
