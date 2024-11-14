import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class anotherDemo {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>(Arrays.asList(2, 5, 7, 4, 5, 6, 4, 7, 9));
        ListIterator<Integer> li = data.listIterator();

        int number = 0;
        while (li.hasNext()) {
            number = li.next();

            if (number % 2 == 1) {
                li.remove();
            }
        }
        System.out.println(data);
    }
}

