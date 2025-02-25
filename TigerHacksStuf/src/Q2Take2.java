import java.util.Scanner;

public class Q2Take2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] lenRul = scan.nextLine().split(" ");
        int len = Integer.parseInt(lenRul[0]);
        int rules = Integer.parseInt(lenRul[1]);
        String word = scan.nextLine();
        char[] c=word.toCharArray();
        for(int i=0; i<rules; i++){
            String indexes[]=scan.nextLine().split(" ");
            int index1=Integer.parseInt(indexes[0]);
            int index2=Integer.parseInt(indexes[1]);
            char temp=c[index1];
            c[index1]=c[index2];
            c[index2]=temp;
        }
        String result="";
        for(char c1: c){
            result+=c1;
        }
        System.out.println(result);

    }
}
