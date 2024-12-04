
public class MyLinkedList {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

    // properties
    private Node front;

    // constructors
    public MyLinkedList() {
        this.front = null;
    }

    // methods
    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        int size = 0;
        Node temp = front;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void add(int x) {
        Node.next = new Node(x);
    }
    // remove
    // get
    // set
    // toString

}
