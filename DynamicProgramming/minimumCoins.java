import java.util.Arrays;

public class minimumCoins {
    public static int minimumCoinsCount(int coin[], int target, int idx) {
        // Base case
        if (idx == 0) {
            if (target % coin[0] == 0) {
                return target / coin[0];
            } else {
                return Integer.MAX_VALUE;
            }
        }
        int notTake = 0 + minimumCoinsCount(coin, target, idx - 1);
        int take = Integer.MAX_VALUE;
        if (coin[idx] <= target) {
            int res = minimumCoinsCount(coin, target - coin[idx], idx);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }
        return Math.min(notTake, take);
    }

    // Memoization way
    public static int minimumCoinsCount(int arr[], int target, int idx, int dp[][]) {
        if (idx == 0) {
            if (target % arr[idx] == 0) {
                return target / arr[idx];
            } else {
                return Integer.MAX_VALUE;
            }
        }
        if (dp[idx][target] != -1)
            return dp[idx][target];
        int notTake = 0 + minimumCoinsCount(arr, target, idx - 1, dp);
        int take = Integer.MAX_VALUE;
        if (arr[idx] <= target) {
            int res = minimumCoinsCount(arr, target - arr[idx], idx, dp);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }
        return dp[idx][target] = Math.min(notTake, take);
    }

    public static int minimumCoinsCountTab(int arr[], int target) {
        int n = arr.length;
        int[][] dp = new int[n][target + 1];

        // Initialize first row (only using arr[0] coin)
        for (int t = 0; t <= target; t++) {
            if (t % arr[0] == 0) {
                dp[0][t] = t / arr[0];
            } else {
                dp[0][t] = Integer.MAX_VALUE;
            }
        }

        // Fill dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MAX_VALUE;

                if (arr[i] <= j) {
                    int res = dp[i][j - arr[i]];
                    if (res != Integer.MAX_VALUE) {
                        take = 1 + res;
                    }
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }

        return dp[n - 1][target] == Integer.MAX_VALUE ? -1 : dp[n - 1][target];
    }
    // Space optimization problem

    public static int minimumCoinsCountSpaceOptimized(int arr[],int target){
        int n=arr.length;
        int dp[]=new int[target+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            for(int j=arr[i];j<=target;j++){
                if(dp[j-arr[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],1+dp[j-arr[i]]);
                }
            }
        }
        return dp[target]==Integer.MAX_VALUE?-1:dp[target];
    }



    public static void main(String[] args) {
        int arr[] = { 9, 5, 6, 1 };
        int target = 11;
        // Recursion way
        // time complexity: O(2^n)>> more than that
        // Space complexity:O(n) more than that O(n ) it takes a auxillarily space
        // System.out.println(minimumCoinsCount(arr, target,arr.length-1));

        // Memoization way:
        // int dp[][]=new int[arr.length][target+1];
        // for(int i=0;i<arr.length;i++){
        // for(int j=0;j<=target;j++){
        // dp[i][j]=-1;
        // }
        // }
        // System.out.println(minimumCoinsCount(arr,target,arr.length-1,dp));

        // Tabulazation way
        // System.out.println(minimumCoinsCountTab(arr, target));

        // Space optimization problem
        System.out.println(minimumCoinsCountSpaceOptimized(arr, target));
    }
}