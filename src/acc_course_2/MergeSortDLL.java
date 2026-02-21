package acc_course_2;


public class MergeSortDLL {

    static class Node {
        int data;
        Node next, prev;

        Node(int d) {
            data = d;
        }
    }

    static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data < b.data) {
            a.next = merge(a.next, b);
            a.next.prev = a;
            return a;
        } else {
            b.next = merge(a, b.next);
            b.next.prev = b;
            return b;
        }
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(5);
        head.next.next.prev = head.next;

        Node sorted = merge(head, null);
        print(sorted);
    }
}
