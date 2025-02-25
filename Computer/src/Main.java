import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Computer[] store = new Computer[7];

        store[0] = new Computer();
        store[1] = new Computer(8, 256, "Dell", 559.89);
        store[2] = new Computer();
        store[3] = new Computer(32, 1024, "Asus", 1499.99);
        store[4] = new Computer(32, 512, "Asus", 1299.99);
        store[5] = new Computer(16, 512, "HP", 924.24);
        store[6] = new Computer(32, 512, "Mac", 5000.00);

        Arrays.sort(store, new Comparator<Computer>() {
            public int compare(Computer c1, Computer c2) {
                int temp = c1.getRam() - c2.getRam();
                if (temp != 0) {
                    return temp;
                }

                if (c1.getCost() > c2.getCost()) {
                    return 1;
                }
                if (c1.getCost() < c2.getCost()) {
                    return -1;
                }

                temp = c1.getStorage() - c2.getStorage();
                if (temp != 0) {
                    return temp;
                }

                return c1.getBrand().compareTo(c2.getBrand());
            }
                });

        for (Computer a : store) {
            System.out.println(a);
        }

    }
}