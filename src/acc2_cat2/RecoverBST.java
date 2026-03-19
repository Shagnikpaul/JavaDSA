package acc2_cat2;


import java.util.Scanner;

public class RecoverBST {
    static TreeNode parent;
    static TreeNode f;
    static TreeNode sec;
    static TreeNode m;

    public static void recover(TreeNode root) {
        if (root == null) {
            return;
        }
        recover(root.left);
        // we are going inorder so values should keep on increasing as we proceed further in a BST tree...
        if (parent != null && root.val < parent.val) {
            if (f == null) {
                // first violation
                // maybe possible there is no second violation so the violation is adjacent to the first violation -> parent, root
                f = parent;
                m = root;
            } else {
                // second
                sec = root;
            }
        }
        parent = root;
        recover(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = TreeNode.buildTree(s);
        TreeNode.printTree(root);
        System.out.println();
        recover(root);

        System.out.println("F violation " + ((f != null) ? f.val : " null"));
        System.out.println("S violation " + ((sec != null) ? sec.val : " null"));
        if (f != null && sec != null) {
            int t = f.val;
            f.val = sec.val;
            sec.val = t;
        } else if (f != null) {
            int t = f.val;
            f.val = m.val;
            m.val = t;
        }
        TreeNode.printTree(root);

    }
}
