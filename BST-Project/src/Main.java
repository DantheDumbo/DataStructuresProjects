public class Main {

    public static boolean isInTree(BSTnode root, int target) {
        BSTnode current = root;
        if (current == null) {
            return false;
        }
        /*
        while (current != null) {
            if (current.left.data > target) {
                current = current.left;
                System.out.println("2");
            } if (current.right.data > target) {
                current = current.right;
                System.out.println("3");
            } if (current.data == target) {
                System.out.println("4");
                return true;
            }
        }

         */
        current = current.left;
        System.out.println(current.data);
        return false;
    }

    public static void add(BSTnode root, int target) {

    }

    public static void printTree(BSTnode root) {
        if (root == null) {
            return;
        }

        printTree(root.left);
        System.out.println(root.data);
        printTree(root.right);
    }

    public static void main(String[] args) {
        BSTnode root = new BSTnode(5);

        root.left = new BSTnode(3);
        root.right = new BSTnode(8);

        root.left.left = new BSTnode(-1);
        root.left.right = new BSTnode(4);

        root.right.left = new BSTnode(7);
        root.right.right = new BSTnode(11);

        root.right.right.right = new BSTnode(13);

        printTree(root);

        System.out.println(isInTree(root, 7));
        System.out.println(isInTree(root, 6));
    }
}