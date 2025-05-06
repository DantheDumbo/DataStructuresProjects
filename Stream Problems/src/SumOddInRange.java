import java.util.stream.IntStream;

public class SumOddInRange {
    public static void main(String[] args) {
        System.out.println(
                IntStream
                        .range(500,1001)
                        .filter(x-> x % 2 != 0)
                        .sum()
        );
    }
}
