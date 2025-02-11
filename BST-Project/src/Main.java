public class Main {

    public static boolean isInTree(BSTnode root, int target) {
        if (root == null) return false;
        while (root.right != null || root.left != null) {
            if (root.data > target) {
                root = root.left;
            } if (root.data > target) {
                root = root.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void add(BSTnode root, int target) {

    }


    public static BSTnode setRoot(BSTnode r) {
        return new BSTnode(-5);
    }

    public static void main(String[] args) {
        BSTnode root = null;
        root = setRoot(root);

        System.out.println(isInTree(root, 7));
    }
}