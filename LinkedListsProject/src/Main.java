public class Main {
    public static void main(String[] args) {
        Node n0 = new Node(7);
        Node n1 = new Node(6);
        Node n2 = new Node(5);
        Node n3 = new Node(4);

        Node front = n0;
        Node temp;

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;


        // prints the list
        System.out.print("[ ");
        temp = front;
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }
        System.out.println("]");
        System.out.println();

        // prints the size
        int size = 0;
        temp = front;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        System.out.println("Size of list is " + size);


        // deletes first element
        if (front != null) {
            front = front.next;
        }

        // prints list
        System.out.print("[ ");
        temp = front;
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }
        System.out.println("]");
        System.out.println();


        // deletes last element
        Node t = front;
        if (t != null) {
            if (t.next == null) {
                t = null;m
            }
            else {
                while (t.next.next != null) {
                    t = t.next;
                }
                t.next = null;
            }
        }


        // prints list
        System.out.print("[ ");
        temp = front;
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }
        System.out.println("]");
        System.out.println();


        // deletes second element
        if (front != null && front.next != null) {
            front.next = front.next.next;
        }

    }
}