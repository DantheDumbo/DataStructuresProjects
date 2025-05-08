import java.util.Arrays;
import java.util.List;

public class FindLengthOfLongestName {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");

        names.stream()
                .sorted((x1,x2) -> x2.length() - x1.length())
                .findFirst()
                .ifPresent(x -> System.out.println(x.length()));
    }
}
