import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String letters = scan.nextLine();
        char[] c = letters.toCharArray();
        String result = "";

        for (int i=0; i < c.length; i++) {
            if (!letters.substring(i,i+1).equals(" ")) {
                if (c[i] + 10 > 'Z') {
                    c[i] += 10-26;
                } else {
                    c[i] += 10;
                }
            }
        }
        for (char a : c) {
            result += a;
        }
        System.out.println(result);
    }
}
