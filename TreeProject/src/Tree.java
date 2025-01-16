public class Tree {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        char data;

        public TreeNode(char data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    private TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public void postOrder() {
        if (this.root == null) {
            return;
        }
        postOrder(this.root);
    }

    private void postOrder(TreeNode t) {
        if (t != null) {
            postOrder(t.left);
            postOrder(t.right);
            System.out.print(t + " ");
        }
    }

    public void preOrder() {
        if (this.root == null) {
            return;
        }
        preOrder(this.root);
    }

    private void preOrder(TreeNode t) {
        if (t != null) {
            System.out.print(t + " ");
            preOrder(t.left);
            preOrder(t.right);
        }
    }

    public void inOrder() {
        if (this.root == null) {
            return;
        }
        inOrder(this.root);
    }

    private void inOrder(TreeNode t) {
        if (t != null) {
            inOrder(t.left);
            System.out.print(t + " ");
            inOrder(t.right);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');

        a.left = b;
        a.right = f;
        b.left = c;
        b.right = d;
        d.left = e;
        f.right = g;

        Tree t = new Tree(a);
        t.preOrder();
        System.out.println();
        t.postOrder();
        System.out.println();
        t.inOrder();
    }
}
