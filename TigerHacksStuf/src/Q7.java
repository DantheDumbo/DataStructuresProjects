import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        String[] instructions = new String[N];

        for (int i = 0; i < N; i++) {
            String[] line = scan.nextLine().split(":");
            instructions[i] = Integer.toString(Integer.parseInt(line[1], Integer.parseInt(line[0])), 10);
            System.out.println(instructions[i]);
        }
        int[] actions = new int[10];
        int index = 0;
        for (String s : instructions) {
            int a = Integer.parseInt(s);
            char b = (char)a;
            String c = String.valueOf(b);
            switch (c) {
                case ">" :
                    index += 1;
                    break;
                case "<" :
                    index -= 1;
                    if (index < 0) {index = 0;}
                    break;
                case "+" :
                    actions[index] = actions[index] + 1;
                    break;
                case "-" :
                    actions[index] = actions[index] - 1;
                    break;
                case "." :
                    System.out.println((char)(actions[index]));
                    break;
                default :
                    System.out.println("err");
                    break;
            }
        }
    }
}
