import java.util.stream.IntStream;

public class RangeWithSkip {
    public static void main(String[] args) {
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(x->System.out.print(x));
        System.out.println();
    }
}
