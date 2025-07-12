package datastructures;

public class Stack {
    Node top;
    int height;

    public Stack(int data) {
        Node n = new Node(data);
        this.top = n;
        this.height = 1;
    }

    public void push(int data) {
        Node n = new Node(data);
        this.top.next = n;
        this.top = n;
    }
}
