import java.util.stream.IntStream;

public class Sum {
    public static void main(String[] args) {
        System.out.println(
                IntStream
                .range(1,101) //last number excluded
                .sum()
        );
        System.out.println();
    }
}
