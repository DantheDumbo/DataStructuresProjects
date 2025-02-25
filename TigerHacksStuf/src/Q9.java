import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        int numofwords = Integer.parseInt(scan.nextLine());
        String[] words = new String[numofwords];
        for (int i = 0; i < numofwords; i++) {
            words[i] = scan.nextLine();
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (words[i].concat(words[j]).equals(word) || words[j].concat(words[i]).equals(word)){
                    System.out.println(Math.min(i, j) + " " + Math.max(i, j));
                }
            }
        }
    }
}
