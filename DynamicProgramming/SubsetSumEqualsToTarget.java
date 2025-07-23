public class SubsetSumEqualsToTarget {
    // Recursion approach
    // First base case
    // If target is 0, we can always form it with an empty subset
    public static boolean canFormTarget(int[] arr, int target, int indx) {
        if (target == 0)
            return true;
        if (indx == 0)
            return arr[0] == target;
        boolean notTake = canFormTarget(arr, target, indx - 1);
        boolean take = false;
        if (arr[indx] <= target) {
            take = canFormTarget(arr, target - arr[indx], indx - 1);
        }
        return take || notTake;
        // Time complexity:O(2^n)
        // Space complexity:O(N)
    }
    // Memoization approach
    // We can get the similar overlapping subproblem
    // we can intilalized the dp array with -1
    public static boolean canFormTargetMemo(int arr[], int target, int idx, int dp[][]) {
        if (target == 0) return true;
        if (idx == 0) return arr[0] == target;
        if (dp[idx][target] != -1) return dp[idx][target] == 1;
        
        boolean notTake = canFormTargetMemo(arr, target, idx - 1, dp);
        boolean take = false;
        if (arr[idx] <= target) {
            take = canFormTargetMemo(arr, target - arr[idx], idx - 1, dp);
        }
        
        boolean result = take || notTake;
        dp[idx][target] = result ? 1 : 0;  // Store 1 for true, 0 for false
        return result;
    }
    // Tabulazation way
    public static boolean canFormTargetTab(int arr[],int target){
        // Make a dp array of size n+1 and target+1
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][target + 1];
        // Base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // We can always form target 0 with an empty subset
        }
        for (int j = 1; j <= target; j++) {
            dp[0][j] = false; // We cannot form any positive target with an empty subset
        }
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        // Dp on subsequence/subsets
        // Recursion way
        int[] arr = { 1, 2, 3, 4, 5 };
        int target = 5;
        int dp[][]=new int[arr.length + 1][target + 1];
        for(int i=0;i<arr.length + 1;i++){
            for(int j=0;j<target + 1;j++){
                dp[i][j]=-1;
            }
        }
        // System.out.println("Can we form the target sum? " + canFormTargetMemo(arr, target, arr.length-1, dp));
        System.out.println("Can we form the target sum? " + canFormTargetTab(arr, target));




        // System.out.println("Can we form the target sum? " + canFormTarget(arr, target, arr.length - 1));

    }
}