import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(repeatedLetters("Java"));         // [a]
        System.out.println(repeatedLetters("Mississippi")); // [i, p, s]
        System.out.println(repeatedLetters("Bookkeeper"));  // [e, k, o]
    }

    public static List<Character> repeatedLetters(String str) {
        // Convert string to lowercase to handle case insensitivity
        str = str.toLowerCase();

        // Use a HashMap to count occurrences of each character
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
        }

        // Collect characters that appear more than once into a sorted list
        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result); // Sort the result alphabetically
        return result;
    }
}
