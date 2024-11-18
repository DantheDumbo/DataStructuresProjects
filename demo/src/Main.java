import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(repeatedLetters("Java"));         // [a]
        System.out.println(repeatedLetters("Mississippi")); // [i, p, s]
        System.out.println(repeatedLetters("Bookkeeper"));  // [e, k, o]
    }

    public static List<Character> repeatedLetters(String str) {
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }

        int[] counts = new int[26];
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (Character.isLetter(c)) {
                counts[Character.toLowerCase(c) - 'a']++;
            }
        }

        List<Character> result = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 1) {
                result.add((char) (i + 'a'));
            }
        }

        return result;
    }
}
