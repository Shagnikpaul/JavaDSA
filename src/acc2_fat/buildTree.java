package acc2_fat;


import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left, right;

    public Node(int x) {
        val = x;
    }
}

public class buildTree {

    public static Node build(int[] l) {
        Node root = new Node(l[0]);
        int i = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty() && i < l.length) {
            Node t = q.remove();
            if (i < l.length && l[i] != -1) {
                t.left = new Node(l[i]);
                q.offer(t.left);
            }
            i++;
            if (i < l.length && l[i] != -1) {
                t.right = new Node(l[i]);
                q.offer(t.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] l = {1, 2, 3, 4, 5, 6, 7};

    }
}
