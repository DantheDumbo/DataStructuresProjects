public class test {
    public static void main(String[] args) {
        int x = 5;
        int y = 9;
        System.out.println("x: " + x + " y: " + y);
        x^=y;
        y^=x;
        x^=y;
        // 1010
        // 0000
        // &
        // 0101
        System.out.println("x: " + x + " y: " + y);
    }
}
