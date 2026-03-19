package acc2_cat2;

import java.util.*;

class Pair {
    TreeNode n;
    int pos;

    public Pair(TreeNode n, int p) {
        this.n = n;
        this.pos = p;
    }
}


public class ViewsOfTree {

    public void horizontalView(TreeNode root) {
        /*
         * NOTE : Its level order traversal here...
         * normally its top / down / vertical view of a tree...
         * */

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        System.out.println("Level order: ");
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 1; i <= s; i++) {
                TreeNode x = q.poll();
                System.out.print(x.val + " ");
                if (x.left != null)
                    q.offer(x.left);
                if (x.right != null)
                    q.offer(x.right);
            }
        }
        System.out.println();
    }


    public void VerticalView(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, ArrayList<TreeNode>> h = new HashMap<>();
        q.offer(new Pair(root, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 1; i <= s; i++) {
                Pair x = q.poll();
                if (x.n.left != null) {
                    q.add(new Pair(x.n.left, x.pos - 1));
                }
                if (x.n.right != null) {
                    q.add(new Pair(x.n.right, x.pos + 1));
                }
                h.putIfAbsent(x.pos, new ArrayList<>());
                h.get(x.pos).add(x.n);
                min = Math.min(x.pos, min);
                max = Math.max(x.pos, max);
            }
        }
        System.out.println("Vertical Order: ");
        for (int i = min; i <= max; i++) {
            for (TreeNode k : h.get(i)) {
                System.out.print(k.val + " ");
            }
        }
        System.out.println();
    }


    public void TopView(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, ArrayList<TreeNode>> h = new HashMap<>();
        q.offer(new Pair(root, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 1; i <= s; i++) {
                Pair x = q.poll();
                if (x.n.left != null) {
                    q.add(new Pair(x.n.left, x.pos - 1));
                }
                if (x.n.right != null) {
                    q.add(new Pair(x.n.right, x.pos + 1));
                }
                h.putIfAbsent(x.pos, new ArrayList<>());
                h.get(x.pos).add(x.n);
                min = Math.min(x.pos, min);
                max = Math.max(x.pos, max);
            }
        }
        System.out.println("Top View: ");
        for (int i = min; i <= max; i++) {
            System.out.print(h.get(i).get(0).val + " ");
        }
        System.out.println();
    }

    public void BottomView(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, ArrayList<TreeNode>> h = new HashMap<>();
        q.offer(new Pair(root, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 1; i <= s; i++) {
                Pair x = q.poll();
                if (x.n.left != null) {
                    q.add(new Pair(x.n.left, x.pos - 1));
                }
                if (x.n.right != null) {
                    q.add(new Pair(x.n.right, x.pos + 1));
                }
                h.putIfAbsent(x.pos, new ArrayList<>());
                h.get(x.pos).add(x.n);
                min = Math.min(x.pos, min);
                max = Math.max(x.pos, max);
            }
        }
        System.out.println("Bottom View: ");
        for (int i = min; i <= max; i++) {
            System.out.print(h.get(i).get(h.get(i).size() - 1).val + " ");
        }
        System.out.println();
    }

    public void LeftView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        System.out.println("Left View: ");
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 1; i <= s; i++) {
                TreeNode x = q.poll();
                if (i == 1)
                    System.out.print(x.val + " ");
                if (x.left != null)
                    q.offer(x.left);
                if (x.right != null)
                    q.offer(x.right);
            }
        }
        System.out.println();
    }

    public void RightView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        System.out.println("Left View: ");
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 1; i <= s; i++) {
                TreeNode x = q.poll();
                if (i == s)
                    System.out.print(x.val + " ");
                if (x.left != null)
                    q.offer(x.left);
                if (x.right != null)
                    q.offer(x.right);
            }
        }
        System.out.println();
    }


    public void leftBoun(TreeNode root, List<TreeNode> l) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        l.add(root);
        if (root.left != null) {
            leftBoun(root.left, l);
        } else {
            leftBoun(root.right, l);
        }
    }

    public void leaves(TreeNode root, List<TreeNode> l) {
        if (root.left != null) {
            leaves(root.left, l);
        }
        if (root.left == null && root.right == null) {
            l.add(root);
        }
        if (root.right != null) {
            leaves(root.right, l);
        }
    }

    public void rightBoun(TreeNode root, List<TreeNode> l) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right != null) {
            leftBoun(root.right, l);
        } else {
            leftBoun(root.left, l);
        }
        l.add(root);
    }

    public void boundaryTraversal(TreeNode root) {
        if (root.right == null && root.left == null) {
            System.out.println("Boundary traversal : \n" + root.val);
            return;
        }
        List<TreeNode> res = new ArrayList<>();
        res.add(root);
        leftBoun(root.left, res);
        leaves(root, res);
        rightBoun(root.right, res);
        System.out.println("Boundary traversal : ");
        for (TreeNode x : res) {
            System.out.print(x.val + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = TreeNode.buildTree(s);
        new ViewsOfTree().boundaryTraversal(root);
    }
}
