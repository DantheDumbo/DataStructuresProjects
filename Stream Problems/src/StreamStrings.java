import java.util.stream.Stream;

public class StreamStrings {
    public static void main(String[] args) {
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted((s1,s2) -> s1.compareTo(s2) * -1)
                // override of sorted method to sort it backwards
                .findFirst()
                .ifPresent(System.out::println);
    }
}
