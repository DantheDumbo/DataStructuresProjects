public class EvaluateBooleanBinaryTree {


    public boolean evaluateTree(TreeNode root) {
        TreeNode right;
        TreeNode left;

        switch(root.val) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return (evaluateTree(root.left) || evaluateTree(root.right));
            default:
                return (evaluateTree(root.left) && evaluateTree(root.right));
        }
    }
}