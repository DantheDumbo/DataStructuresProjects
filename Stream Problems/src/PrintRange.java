import java.util.stream.*;

public class PrintRange {
    public static void main(String[] args) {
        IntStream
                .range(1,10)
                .forEach(System.out::print);
        System.out.println();
    }
}
