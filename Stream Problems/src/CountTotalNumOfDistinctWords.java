import java.util.*;
import java.util.stream.*;

public class CountTotalNumOfDistinctWords {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java Stream API proved a fluent interface for processing sequences of element.",
                "It supports functional-style operations on streams of elements, such as map-rec",
                "In this exercise, you need to count the total number of words in all sentences.");

        long count = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split("\\W+"))) // split into words
                .filter(word -> !word.isEmpty()) // remove any empty results
                .map(String::toLowerCase) // make it case-insensitive
                .distinct()
                .count();

        System.out.println(count);
    }
}
