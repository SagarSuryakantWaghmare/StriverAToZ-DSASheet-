public class MinimizeMaximumDistanceBetweenGasStations {
    public static double minimumMaxDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;

        // Calculate the maximum possible distance between stations
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double diff = 1e-6; // Small tolerance for precision
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int count = numberOfGasStationsRequired(mid, arr);
            if (count > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }

    public static int numberOfGasStationsRequired(double dist, int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            double gap = arr[i + 1] - arr[i];
            count += (int) Math.floor(gap / dist); // Number of additional stations needed
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int k = 4;
        System.out.printf("%.6f\n", minimumMaxDistance(arr, k));
    }
}
