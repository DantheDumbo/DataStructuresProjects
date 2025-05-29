import java.util.stream.Stream;

public class ReduceExample {
    public static void main(String[] args) {
        // example of doing a sum using a reduce method
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a+b);
        System.out.println(total);
    }
}
