public class BST {
    private BSTnode root;

    public BST() {
        this.root = null; // Initialize an empty tree
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private BSTnode addRecursive(BSTnode current, int value) {
        if (current == null) {
            return new BSTnode(value); // Create a new node if the tree/subtree is empty
        }

        if (value < current.data) {
            current.left = addRecursive(current.left, value); // Add to left subtree
        } else if (value > current.data) {
            current.right = addRecursive(current.right, value); // Add to right subtree
        }
        // Ignore duplicates
        return current; // Return the updated tree
    }

    public boolean isInTree(int target) {
        return isInTreeRecursive(root, target);
    }

    private boolean isInTreeRecursive(BSTnode current, int target) {
        if (current == null) {
            return false; // Reached the end, target not found
        }
        if (current.data == target) {
            return true; // Found the target
        }
        return target < current.data
                ? isInTreeRecursive(current.left, target) // Search left subtree
                : isInTreeRecursive(current.right, target); // Search right subtree
    }

    public void printTree() {
        printTreeRecursive(root);
        System.out.println();
    }

    private void printTreeRecursive(BSTnode current) {
        if (current != null) {
            printTreeRecursive(current.left); // In-order traversal
            System.out.print(current.data + " ");
            printTreeRecursive(current.right);
        }
    }

    // Inner class representing a single node in the tree
    private static class BSTnode {
        int data;
        BSTnode left;
        BSTnode right;

        public BSTnode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
