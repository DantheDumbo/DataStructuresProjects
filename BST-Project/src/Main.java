public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(20);

        System.out.println("Tree contents:");
        tree.printTree(); // Expected output: 3 5 7 10 12 15 20

        System.out.println("\nIs 7 in the tree? " + tree.isInTree(7)); // Expected: true
        System.out.println("Is 8 in the tree? " + tree.isInTree(8)); // Expected: false

        System.out.println("\nAdding 8 to the tree...");
        tree.add(8);

        System.out.println("Updated tree contents:");
        tree.printTree(); // Expected output: 3 5 7 8 10 12 15 20

        System.out.println("\nIs 8 in the tree now? " + tree.isInTree(8)); // Expected: true


        System.out.println("\nDeleting 3 in tree...");
        tree.delete(3);

        System.out.println("Updated tree contents:");
        tree.printTree(); // Expected output: 5 7 8 10 12 15 20

        System.out.println("\nDeleting 7 in tree...");
        tree.delete(7);

        System.out.println("Updated tree contents:");
        tree.printTree(); // Expected output: 5 8 10 12 15 20

        System.out.println("\nDeleting 10 in tree...");
        tree.delete(10);

        System.out.println("Updated tree contents:");
        tree.printTree(); // Expected output: 5 7 8 12 15 20
    }
}