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

    // add
    public void add(int x) {
        if (front == null) {
            front = new Node(x);
        } else {
            Node temp = front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(x);
        }
    }

    // remove
    public Integer remove(int index) {
        if (index < 0 || front == null) {
            return null; // Invalid index or empty list
        }

        if (index == 0) { // Removing the first element
            int removedData = front.data;
            front = front.next;
            return removedData;
        }

        Node temp = front;
        for (int i = 0; i < index - 1; i++) { // Traverse to the node before the one to remove
            if (temp.next == null) {
                return null; // Index out of bounds
            }
            temp = temp.next;
        }

        if (temp.next != null) {
            int removedData = temp.next.data;
            temp.next = temp.next.next;
            return removedData;
        }

        return null; // Index out of bounds
    }

    // get
    public Integer get(int index) {
        if (index < 0 || front == null) {
            return null;
        }

        Node temp = front;
        for (int i = 0; i < index; i++) {
            if (temp.next == null) {
                return null; // Index out of bounds
            }
            temp = temp.next;
        }
        return temp.data;
    }

    // set
    public boolean set(int index, int value) {
        if (index < 0 || front == null) {
            return false; // Invalid index or empty list
        }

        Node temp = front;
        for (int i = 0; i < index; i++) {
            if (temp.next == null) {
                return false; // Index out of bounds
            }
            temp = temp.next;
        }

        temp.data = value;
        return true;
    }

    // toString
    @Override
    public String toString() {
        if (front == null) {
            return "[]";
        }

        StringBuilder str = new StringBuilder("[");
        Node temp = front;
        while (temp != null) {
            str.append(temp.data);
            if (temp.next != null) {
                str.append(", ");
            }
            temp = temp.next;
        }
        str.append("]");
        return str.toString();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < 6; i++) {
            list.add(i + 1);
        }
        System.out.println(list); // [1, 2, 3, 4, 5, 6]
        System.out.println(list.size()); // 6
        System.out.println(list.remove(0)); // 1
        System.out.println(list); // [2, 3, 4, 5, 6]
        System.out.println(list.get(2)); // 4
        list.set(2, 8);
        System.out.println(list); // [2, 3, 8, 5, 6]

        MyLinkedList list1 = new MyLinkedList();
        System.out.println(list1); // []
        System.out.println(list1.remove(0)); // null
        list1.add(1);
        System.out.println(list1); // [1]
        list1.remove(0);
        System.out.println(list1); // []
    }
}
