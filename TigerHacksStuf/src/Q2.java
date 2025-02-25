import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] lenRul = scan.nextLine().split(" ");
        int len = Integer.parseInt(lenRul[0]);
        int rules = Integer.parseInt(lenRul[1]);

        String word = scan.nextLine();
        for (int i = 0;  i < rules; i++) {
            String newWord = "";
            String[] indexs = scan.nextLine().split(" ");
            newWord += word.substring(0, Math.min(Integer.parseInt(indexs[0]), Integer.parseInt(indexs[1])));
            newWord += word.charAt(Math.max(Integer.parseInt(indexs[0]), Integer.parseInt(indexs[1])));
            newWord += word.substring(Math.min(Integer.parseInt(indexs[0]), Integer.parseInt(indexs[1])) + 1,
                    Math.max(Integer.parseInt(indexs[0]), Integer.parseInt(indexs[1])));
            newWord += word.charAt(Math.min(Integer.parseInt(indexs[0]), Integer.parseInt(indexs[1])));
            newWord += word.substring(Math.max(Integer.parseInt(indexs[0]), Integer.parseInt(indexs[1])) + 1);

            word = newWord;
        }
        System.out.println(word);
    }
}
