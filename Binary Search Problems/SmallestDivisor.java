public class SmallestDivisor {
    public static boolean isDivisor(int mid, int arr[], int threshold) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // Correctly cast integers to double before division
            sum += Math.ceil((double) arr[i] / mid);
        }
        return sum <= threshold;
    }

    public static int smallestDivisor(int[] arr, int threshold) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        int low = 1;
        int high = maxi;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isDivisor(mid, arr, threshold)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(arr, threshold));
    }
}
