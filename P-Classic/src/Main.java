
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        ArrayList<Integer> a = new ArrayList<>();
        int count = 1;
        while (count * count <= num) {
            a.add(count * count);
            count++;
        }

        for (int i = a.size() - 1; i >= 0; i--) {
            String newNum = a.get(i) + "";
            if (newNum.indexOf('0') >= 0) {
                a.remove(i);
                continue;
            }
            newNum = newNum.replaceAll("0", "");
            if ((Math.sqrt(Double.parseDouble(newNum))) % 1 != 0) {
                a.remove(i);
            }
        }

        System.out.println(a.size());
    }
}
