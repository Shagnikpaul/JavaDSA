package dsa.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args) {

    }
}

class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int sizeBefore = queue.size();
        queue.add(x);

        for (int i = 1; i <= sizeBefore; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        boolean res = queue.isEmpty();
        return res;
    }
}
