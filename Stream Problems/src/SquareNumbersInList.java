import java.util.Arrays;
import java.util.List;

public class SquareNumbersInList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        numbers.stream()
                .map(x -> x * x)
                .forEach(System.out::println);
    }
}
