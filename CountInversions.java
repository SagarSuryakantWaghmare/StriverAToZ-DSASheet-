import java.util.Arrays;

public class CountInversions {
    // public static int countInversions(int[] arr) {
    //     // Brute force approach
    //     int count = 0;
    //     for (int i = 0; i < arr.length - 1; i++) {
    //         for (int j = i+1; j < arr.length; j++) {
    //             if (arr[i] > arr[j]) {
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    public static int countInversions(int[] arr) {
        // Optimized approach
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }
    public static int mergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }
    public static int mergeAndCount(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l, swaps = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return swaps;
    }

    // Optimized approach
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(countInversions(arr));
    }
}
