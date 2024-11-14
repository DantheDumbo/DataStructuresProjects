import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        /*
        Stack operations:
        -Push (returns void)
            Adds element to top and moves top up 1
        -Pop (returns element)
            Returns top value and moves top down (essentialy deleting the element)
        -Peak (returns element)
            Returns top value
        -Size (returns int)
            Returns size
        -
         */

        List<String> pieFlavors = new ArrayList<>(Arrays.asList("Apple", "Pecan", "Lemon", "Peach", "Pumpkin"));

        System.out.println(pieFlavors);


        Stack<String> stack = new Stack<>();

        for (int i = 0; i < pieFlavors.size(); i++) {
            stack.push(pieFlavors.get(i));
        }

        pieFlavors.clear();

        while (!stack.isEmpty()) {
            pieFlavors.add(stack.pop());
        }

            System.out.println(pieFlavors);
    }
}