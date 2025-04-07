public class Quicksort {

    public int getPivot(int[] arr) {

        int a = arr[0];
        int b = arr[arr.length / 2];
        int c = arr[arr.length - 1];

        if ((a > b) != (a > c)) return a;
        else if ((b > a) != (b > c)) return b;
        else return c;
    }

    public int[] quicksort(int[] arr) {
        if (arr == null) {
            return arr;
        }
        int pivot = getPivot(arr);
        return new int[]{0, 2, 3};
    }

    public static void main(String[] args) {
        int[] arr = {5,8,2,4,5,0,2,2,7};
    }
}
