package acc_course_2;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LoopDetection {
    public static void loop(Node h) {
        if (h == null) {
            System.out.println("NO LOOP");
        }

        Node s = h;
        Node f = h.next;

        while (f != null && f.next != null) {
            if (s == f) {
                System.out.println("Loop detected !!");
                return;
            }
            s = s.next;
            f = f.next.next;
        }
        System.out.println("NO LOOP");
    }

    public static void main(String[] args) {
        Node head7 = new Node(5);
        Node t2 = new Node(6);
        Node t3 = new Node(7);
        head7.next = t2;
        t2.next = t3;
        t3.next = t3;      // self-loop at tail


        Node head4 = new Node(1);
        head4.next = new Node(2);
        head4.next.next = new Node(3);
        head4.next.next.next = new Node(4);


        loop(head4);
    }
}
