import java.util.HashMap;
import java.util.Map;

public class Main {
        public static void main(String[] args) {
            Map<Character, Integer> gValues = new HashMap<>();
            gValues.put('A', 4);
            gValues.put('B', 5);
            gValues.put('C', 2);
            gValues.put('D', 0);
            gValues.put('E', 0);
            gValues.put('F', 0);
            gValues.put('G', 3);
            gValues.put('H', 0);
            gValues.put('I', 0);
            gValues.put('J', 0);
            gValues.put('K', 0);
            gValues.put('L', 6);
            gValues.put('M', 0);
            gValues.put('N', 0);
            gValues.put('O', 5);
            gValues.put('P', 1);
            gValues.put('Q', 0);
            gValues.put('R', 6);
            gValues.put('S', 0);
            gValues.put('T', 6);
            gValues.put('U', 0);
            gValues.put('V', 6);
            gValues.put('W', 0);
            gValues.put('X', 0);
            gValues.put('Y', 5);
            gValues.put('Z', 0);

            String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
            String[] monthsAfterHash; 

            for (String month : months) {
                char secondChar = month.charAt(1);
                char thirdChar = month.charAt(2);
                int hash = gValues.get(secondChar) + gValues.get(thirdChar);
                System.out.println();
            }
        }
    }