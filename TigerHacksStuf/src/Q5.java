import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][][] grid = new int[5][5][n];

        for (int row = 0; row < (n * 5); row++) {
            String[] nums = scan.nextLine().split(" ");
            for (int col = 0; col < 5; col++) {
                if (nums[col].equals("?")) {
                    nums[col] = "" + ((row % 5) + (row / 5) - col);
                }
                grid[row % 5][col][row/5] = Integer.parseInt(nums[col]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int[] coordsMax = new int[2];
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < 5; i++) {
                int sum = 0;
                for (int j = 0; j < 5; j++) {
                    sum += grid[i][j][k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    coordsMax[0] = k;
                    coordsMax[1] = i;
                }
            }
        }
        System.out.println(coordsMax[0] + " " + coordsMax[1]);
    }
}