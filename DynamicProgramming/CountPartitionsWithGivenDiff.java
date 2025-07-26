public class CountPartitionsWithGivenDiff {
    
    // Method to count partitions with given difference using tabulation
    public static int countPartitionsWithDiff(int[] arr, int d) {
        int n = arr.length;
        int totalSum = 0;
        
        // Calculate total sum
        for (int num : arr) {
            totalSum += num;
        }
        
        // Check if partition is possible
        // For S1 - S2 = d and S1 + S2 = totalSum
        // Solving: S2 = (totalSum - d) / 2
        if ((totalSum - d) < 0 || (totalSum - d) % 2 != 0) {
            return 0;
        }
        
        int target = (totalSum - d) / 2;
        
        // Use subset sum count approach
        return countSubsetSum(arr, target);
    }
    
    // Helper method to count subsets with given sum
    private static int countSubsetSum(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];
        
        // Base case: empty subset has sum 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                // Don't include current element
                dp[i][j] = dp[i - 1][j];
                
                // Include current element if possible
                if (j >= arr[i - 1]) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        
        return dp[n][target];
    }
    
    // Space optimized version using 1D array
    public static int countPartitionsWithDiffOptimized(int[] arr, int d) {
        int n = arr.length;
        int totalSum = 0;
        
        // Calculate total sum
        for (int num : arr) {
            totalSum += num;
        }
        
        // Check if partition is possible
        if ((totalSum - d) < 0 || (totalSum - d) % 2 != 0) {
            return 0;
        }
        
        int target = (totalSum - d) / 2;
        
        // Use 1D DP array
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case
        
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[target];
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {5, 2, 6, 4};
        int d1 = 3;
        System.out.println("Array: [5, 2, 6, 4], Difference: " + d1);
        System.out.println("Count of partitions: " + countPartitionsWithDiff(arr1, d1));
        System.out.println("Count (optimized): " + countPartitionsWithDiffOptimized(arr1, d1));
        System.out.println();
        
        // Test case 2
        int[] arr2 = {1, 1, 2, 3};
        int d2 = 1;
        System.out.println("Array: [1, 1, 2, 3], Difference: " + d2);
        System.out.println("Count of partitions: " + countPartitionsWithDiff(arr2, d2));
        System.out.println("Count (optimized): " + countPartitionsWithDiffOptimized(arr2, d2));
        System.out.println();
        
        // Test case 3
        int[] arr3 = {1, 6, 11, 5};
        int d3 = 1;
        System.out.println("Array: [1, 6, 11, 5], Difference: " + d3);
        System.out.println("Count of partitions: " + countPartitionsWithDiff(arr3, d3));
        System.out.println("Count (optimized): " + countPartitionsWithDiffOptimized(arr3, d3));
    }
}
