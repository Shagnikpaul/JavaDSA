package acc_course_2;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode rigth) {
        this.val = val;
        this.left = left;
        this.right = rigth;
    }
}

public class PreOrderTraversal {
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
