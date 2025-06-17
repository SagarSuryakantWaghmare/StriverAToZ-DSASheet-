import java.util.ArrayList;

public class CountInversion {

    public static int countInversionsBruteForce(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    count++;  // corrected condition
                }
            }
        }
        return count;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
        }
        return count;
    }

    public static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> a = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int count = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                a.add(arr[left++]);
            } else {
                a.add(arr[right++]);
                count += (mid - left + 1); 
            }
        }

        while (left <= mid) {
            a.add(arr[left++]);
        }
        while (right <= high) {
            a.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = a.get(i - low);
        }

        return count;
    }

    public static int countUsingMerge(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = {5, 3, 2, 4, 1};

        // Brute-force approach
        System.out.println("Brute-force inversions: " + countInversionsBruteForce(arr.clone()));

        // Merge sort approach
        System.out.println("Merge sort inversions: " + countUsingMerge(arr.clone()));
    }
}
