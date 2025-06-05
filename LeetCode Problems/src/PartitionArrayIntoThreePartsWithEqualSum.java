import java.util.Arrays;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int n: arr) {
            sum += n;
        }

        if (sum % 3 != 0) {
            return false;
        }

        int target = sum / 3;
        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            currentSum += arr[i];
            if (currentSum == target) {
                currentSum = 0;
                count++;
                if (count == 2) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(canThreePartsEqualSum(arr));
    }
}
