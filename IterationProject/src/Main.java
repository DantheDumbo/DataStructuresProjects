import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>(
                Arrays.asList(2, 5, 7, 4, 5)
        );

        ListIterator<Integer> li = data.listIterator();

        while (li.hasNext()) { //forward parse
            System.out.println(li.next());
        }

        System.out.println("--------");

        while (li.hasPrevious()) { //backwards parse
            System.out.println(li.previous());
        }

        // loop again using an iterator
        Iterator<Integer> it = data.iterator();
        while (it.hasNext()) {
            System.out.println(it.next()); // prints the next element
        }
    }
}