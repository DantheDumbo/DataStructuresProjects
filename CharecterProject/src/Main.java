import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] stuff = new int[256];

        File f = new File("poem.txt");
        Scanner scan = new Scanner(f);
        String line = scan.nextLine(); // read the first line (n)
        int n = Integer.parseInt(line); // converting "3" -> 3

        for (int i = 0; i < n; i++) {
            line = scan.nextLine(); // read the next line
            for (int j = 0; j < line.length(); j++) {
                char currentChar = line.charAt(j);
                if (currentChar >= 'a' && currentChar <= 'z') {
                    stuff[currentChar] += 1;
                }
            }
        }

        for (int i = 'a'; i <= 'z'; i++) {
            System.out.println((char) i + ": " + stuff[i]);
        }
    }
}