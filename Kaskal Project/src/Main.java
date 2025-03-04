import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2); //return the natural ordering
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomComparator());

        pq.add(9);
        pq.add(4);
        pq.add(4);
        pq.add(-3);
        pq.add(7);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        pq.add(1);
        pq.add(2);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}