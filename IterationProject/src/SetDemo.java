import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        /*
        sets cant have two or more of the same elements
        Hash sets don't have their elements in order
        Tree sets sort their elements in ascending order

        how to make set - Set<Integer> s1 = new HashSet<>();
        how to make set with shortcut - Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3));

        s1.add(9); // adds 9 to set
        s1.isEmpty(); // returns true if set is empty
        s1.contains(9); // returns true if set contains 9
        s1.remove(9); // element found and removed

        s1.addAll(s2); // Union of two sets (puts all the elements into one set)
        s1.retainAll(s2) // Intersection of two sets (puts only the elements into the new set that were in both sets)
        these two methods are a part of the collections interface therefore they work for all classes that implement the collections interface
         */
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3,4,5,6));

        Set<Integer> set = new HashSet<>(s1);
        set.addAll(s2);
        set.retainAll(s2);

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next()); // prints the next element

        }

        List<Integer> list = new ArrayList<>(Arrays.asList(4,4,7,8,5,5,5));

        for (int a : list) {
            System.out.println(a);
        }

        Set<Integer> data = new HashSet<>(list);
        Iterator<Integer> thing = set.iterator();
        List<Integer> secondList = new ArrayList<>();

        while (thing.hasNext()) {
            secondList.add(thing.next());

        }

        for (int a : secondList) {
            System.out.println(a);
        }
    }
}
