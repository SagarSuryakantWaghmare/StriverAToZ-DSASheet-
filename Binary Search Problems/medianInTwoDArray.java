public class medianInTwoDArray {
    public static int upperBound(int arr[], int x, int n) {
        int low = 0;
        int high = arr.length - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int countSmallEqual(int[][] arr, int n, int m, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += upperBound(arr[i], x, n);
        }
        return count;
    }

    public static int search(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, arr[i][0]);
            high = Math.max(high, arr[i][n - 1]);

        }
        int req = (n + m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(arr, n, m, mid);
            if (smallEqual <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int arr[][] = {
                // row wise sorted
                { 1, 5, 7, 9, 11 },
                { 2, 3, 4, 5, 10 },
                { 9, 10, 12, 14, 16 } };
        System.out.println(search(arr));

    }

}
