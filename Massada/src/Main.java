/*
Massada problem
Prints the 256 combinations of who survives

* Daniel Tuma
 */
public class Main {

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

    public static void main(String[] args) {
        int numPeople;
        Node temp;
        Node front;

        for (int i=1; i <= 256; i++) {
            numPeople = i;
            front = new Node(1);
            temp = front;

            for (int j = 2; j <= i; j++) {
                temp.next = new Node(j);
                temp = temp.next;
            }
            temp.next = front;
            temp = front;

            while (numPeople > 1) {
                temp.next = temp.next.next;
                temp = temp.next;
                --numPeople;
            }
            System.out.println("Person " + temp + " survived with " + i + " people. ");
        }
    }
}