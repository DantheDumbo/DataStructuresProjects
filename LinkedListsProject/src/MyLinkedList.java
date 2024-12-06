
public class MyLinkedList {

    public static class Node {
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
    private Node temp;

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
        temp = front;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    // add
    public void add (int x) {
        if (front == null) {
            front = new Node(x);
        }
        else {
            temp = front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(x);
        }
    }

    // remove
    public void remove (int x) {
        if (front != null) {
            temp = front;
            for (int i=0; i<x; i++) {
                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    break;
                }
            }
            if (temp.next != null && temp.next.next != null) {
                temp.next = temp.next.next;
            }
        }
    }

    // get
    public Integer get (int x) {
        if (front != null) {
            temp = front;
            for (int i=0; i<x; i++) {
                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    break;
                }
            }
            return temp.data;
        }
        return null;
    }

    // toString
    public String toString() {
        if (front == null) {
            return "";
        }
        String str = "";
        temp = front;
        while (temp.next != null) {
            str += temp.data + "";
            temp = temp.next;
        }
        return str;
    }
}
