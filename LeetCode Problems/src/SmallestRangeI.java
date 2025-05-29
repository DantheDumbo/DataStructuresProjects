public class SmallestRangeI {
    public static int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int diff = max - min;

        return Math.max(0, diff - 2 * k);
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 6};
        System.out.println(smallestRangeI(x, 3));  // Output: 0
    }
}
