import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableExample {
    public static void main(String[] args) {
        Hashtable<String, Integer> numbers = new Hashtable<>();

        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);

        System.out.println("Hashtable: " + numbers);

        int value = numbers.get("two");
        System.out.println("Value for key 'two': " + value);

        numbers.remove("two");
        System.out.println("Hashtable after removing 'two': " + numbers);

        Enumeration<String> keys = numbers.keys();
        while(keys.hasMoreElements())
            String
    }
}
