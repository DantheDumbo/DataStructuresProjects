public class Smallest_Range_I {
    public static int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        for (int x : nums) {
            if (min > x) min = x;
            if (max < x) max = x;
        }

        int goal = (int)((max + min) / 2);

        for (int i=0; i < nums.length; i++) {
            if (nums[i] < goal) {
                if (goal - nums[i] >= k) {
                    nums[i] = nums[i] + k;
                }
                else {
                    nums[i] = goal;
                }
            }
            else {
                if (nums[i] - goal >= k) {
                    nums[i] = nums[i] - k;
                }
                else {
                    nums[i] = goal;
                }
            }
        }

        for (int x : nums) {
            if (min > x) min = x;
            if (max < x) max = x;
        }
        return max - min;
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 6};
        System.out.println(smallestRangeI(x, 3));
    }
}
