import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Mapping characters to their associated values
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

        // List of month abbreviations in calendar order
        String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

        // List to store month + hash + calendar index
        List<MonthHash> monthHashes = new ArrayList<>();

        // Fill the list with hash values and calendar order
        for (int i = 0; i < months.length; i++) {
            String month = months[i];
            char secondChar = month.charAt(1);
            char thirdChar = month.charAt(2);
            int hash = gValues.get(secondChar) + gValues.get(thirdChar);
            monthHashes.add(new MonthHash(month, hash, i));
        }

        // Sort primarily by hash, secondarily by calendar index
        monthHashes.sort(Comparator
                .comparingInt((MonthHash mh) -> mh.hash)
                .thenComparingInt(mh -> mh.index));

        // Print results
        for (MonthHash mh : monthHashes) {
            System.out.println(mh.month + " -> " + mh.hash);
        }
    }

    // Helper class to store month, hash, and calendar index
    static class MonthHash {
        String month;
        int hash;
        int index;

        MonthHash(String month, int hash, int index) {
            this.month = month;
            this.hash = hash;
            this.index = index;
        }
    }
}
