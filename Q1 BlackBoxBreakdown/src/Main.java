import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str = scan.nextLine();
        int count = 0;

        String word = "pclassic";

        Set<String> set = new HashSet<String>();

        for (int i = 0; i < word.length() - 1; i++) {
            set.add(word.substring(i, i + 1));
        }

        for (int i=0; i<str.length(); i++) {
            if (set.contains(str.substring(i, i + 1))) {
                count++;
            }
        }
        System.out.println(count);
    }
}