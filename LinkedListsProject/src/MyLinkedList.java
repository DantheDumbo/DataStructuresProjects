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

    // contractors
    public MyLinkedList() {
        this.front = null;
    }

    // methods

    // public boolean isEmpty
    // public int size
    // add
    // remove
    // get
    // set
    // toString

}
