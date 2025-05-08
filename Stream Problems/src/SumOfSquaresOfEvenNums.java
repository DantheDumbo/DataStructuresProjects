import java.util.Arrays;
import java.util.List;

public class SumOfSquaresOfEvenNums {
    public static void main(String[] args) {
        List<Integer> words = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println(
                words.stream()
                        .filter(x -> x % 2 == 0)
                        .map(n -> n * n)
                        .reduce(0, Integer::sum)
        );
    }
}
