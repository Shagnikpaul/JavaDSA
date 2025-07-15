package datastructures.bst;

public class BSTOperations {
    public static void insert(int value, BSTConstructor bstTree) {
        if (bstTree.root == null) {
            bstTree.root = new Node(value);
            return;
        } else {
            Node t = bstTree.root;
            while (t != null) {
                if (t.value < value) {
                    if (t.right == null) {
                        t.right = new Node(value);
                        return;
                    }
                    t = t.right;
                } else if (t.value > value) {
                    if (t.left == null) {
                        t.left = new Node(value);
                        return;
                    }
                    t = t.left;
                } else {
                    System.out.println("Cant insert the duplicate value : " + value);
                    return;
                }
            }
            t = new Node(value);
        }
    }
}
