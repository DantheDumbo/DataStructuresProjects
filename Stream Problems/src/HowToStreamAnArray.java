import java.util.Arrays;

public class HowToStreamAnArray {
    public static void main(String[] args) {
        String [] names = {"Al", "Ankid", "Kushal", "Brent", "Sarika",
                "Kartik", "Rachit", "Saksham", "Keeran", "Krish"};

        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
    }
}
