public class BST {
    private BSTnode root;

    public BST() {
        this.root = null;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private BSTnode deleteRecursive(BSTnode current, int value) {
        if (current == null) {
            return null; // Base case: the value is not found
        }

        if (value < current.data) {
            // If the value is smaller, go to left subtree
            current.left = deleteRecursive(current.left, value);
        } else if (value > current.data) {
            // If the value is larger, go to right subtree
            current.right = deleteRecursive(current.right, value);
        } else {
            // Node to delete is found

            // Case 1: No children (leaf node)
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Only one child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // Case 3: Two children
            // Find the smallest value in the right subtree
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue; // Replace the current node's value with the smallest value
            // Delete the smallest value in right tree
            current.right = deleteRecursive(current.right, smallestValue);
        }

        return current; // Return the updated node
    }

    private int findSmallestValue(BSTnode root) {
        if (root.left == null) {
            // If there is no left child, this node is the smallest
            return root.data;
        } else {
            // Otherwise, keep going left to find the smallest value
            return findSmallestValue(root.left);
        }
    }



    public void add(int value) {
        root = addRecursive(root, value);
    }

    private BSTnode addRecursive(BSTnode current, int value) {
        if (current == null) {
            return new BSTnode(value);
        }

        if (value < current.data) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.data) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isInTree(int target) {
        BSTnode current = root;

        while (current != null) {
            if (current.data == target) {
                return true;
            } else if (target < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }


    public void printTree() {
        printTreeRecursive(root);
        System.out.println();
    }

    private void printTreeRecursive(BSTnode current) {
        if (current != null) {
            printTreeRecursive(current.left);
            System.out.print(current.data + " ");
            printTreeRecursive(current.right);
        }
    }

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