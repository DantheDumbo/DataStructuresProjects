public class Main {
    public static void main(String[] args) {
        Node n0 = new Node(7);
        Node n1 = new Node(6);
        Node n2 = new Node(5);
        Node n3 = new Node(4);

        Node front = n0;

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        System.out.print("[ ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }
        System.out.println("]");
        System.out.println();

        int size = 0;
        temp = front;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        System.out.println("Size of list is " + size);
    }
}