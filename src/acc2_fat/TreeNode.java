package acc2_fat;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v) {
        this.val = v;
        this.left = null;
        this.right = null;
    }


    public static TreeNode buildTree(String inp) {
        String[] nodes = inp.split(" ");
        Integer[] l = new Integer[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].equals("null")) {
                l[i] = null;
            } else {
                l[i] = Integer.parseInt(nodes[i]);
            }
        }
        if (l == null || l.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(l[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < l.length) {
            TreeNode x = q.poll();
            if (i < l.length && l[i] != null) {
                x.left = new TreeNode(l[i]);
                q.offer(x.left);
            }
            i++;
            if (i < l.length && l[i] != null) {
                x.right = new TreeNode(l[i]);
                q.offer(x.right);
            }
            i++;
        }
        return root;
    }


    public static void printTree(TreeNode root) {

        if (root == null) {
            System.out.println("null");
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                System.out.print("null ");
                continue;
            }

            System.out.print(curr.val + " ");
            q.offer(curr.left);
            q.offer(curr.right);
        }
    }


}
