import java.util.Arrays;

public class Quicksort {

    public int getPivotIndex(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int a = arr[low];
        int b = arr[mid];
        int c = arr[high];

        if ((a > b) != (a > c)) return low;
        else if ((b > a) != (b > c)) return mid;
        else return high;
    }

    public int[] quicksort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        quicksortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    private void quicksortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksortHelper(arr, low, pivotIndex);
            quicksortHelper(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivotIndex = getPivotIndex(arr, low, high);
        int pivot = arr[pivotIndex];
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[low];
        arr[low] = temp;

        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        Quicksort sorter = new Quicksort();

        int[] arr1 = {5, 8, 2, 4, 5, 0, 2, 2, 7};
        System.out.println("Original: " + Arrays.toString(arr1));
        sorter.quicksort(arr1);
        System.out.println("Sorted:   " + Arrays.toString(arr1));

        int[] arr2 = {3, 1, 4, 1, 5, 9, 2};
        System.out.println("\nOriginal: " + Arrays.toString(arr2));
        sorter.quicksort(arr2);
        System.out.println("Sorted:   " + Arrays.toString(arr2));

        int[] arr3 = {};
        System.out.println("\nOriginal: " + Arrays.toString(arr3));
        sorter.quicksort(arr3);
        System.out.println("Sorted:   " + Arrays.toString(arr3));
    }
}
