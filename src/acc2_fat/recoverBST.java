package acc2_fat;

public class recoverBST {
    static TreeNode f = null;
    static TreeNode m = null;
    static TreeNode s = null;
    static TreeNode p = null;

    public void r(TreeNode r) {
        if (r == null)
            return;

        r(r.left);

        if (p == null || r.val < p.val) {
            if (f == null) {
                f = p;
                m = r;
            } else {
                s = r;
            }
        }
        p = r;
        r(r.right);
    }
}
