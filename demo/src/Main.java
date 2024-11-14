import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(removeDuplicateWords("This one has a little star. This one has a little car."));
        System.out.println(removeDuplicateWords("One fish, two fish, red fish, blue fish"));
        System.out.println(removeDuplicateWords("James while John had had had had had had had had had had had a better effect on the teacher"));
    }
    public static ArrayList removeDuplicateWords(String sentence) {
        String[] words = sentence.toLowerCase().split("\\W+"); // Convert to lowercase and split by non-word characters
        Set<String> seen = new LinkedHashSet<>(); // Use LinkedHashSet to maintain insertion order and remove duplicates

        for (String word : words) {
            if (!word.isEmpty()) { // Check for any empty words in case of extra spaces or punctuation
                seen.add(word);
            }
        }

        return new ArrayList<>(seen); // Convert LinkedHashSet to Arra
    }


}