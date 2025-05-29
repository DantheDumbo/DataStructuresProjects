import java.util.Arrays;
import java.util.List;

public class ConcatFirstTwoWordsWIthEvenLengths {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        System.out.println(
        words.stream()
                .filter(x -> x.length() % 2 == 0)
                .limit(2)
                .reduce("", (String a, String b) -> a+b)

        );
    }
}
