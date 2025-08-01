import java.util.Arrays;

public class TargetSum {
    // Recursion way
    public static int targetSum(int arr[],int target,int idx,int currCount){
        if(idx==arr.length){
            return target==currCount?1:0;
        }
        int add=targetSum(arr, target, idx+1, currCount+arr[idx]);
        int sub=targetSum(arr, target, idx+1, currCount-arr[idx]);
        return add+sub;
    }
    public static int targetSumMem(int arr[], int target, int idx, int currSum, int[][] dp, int offset) {
        if (idx == arr.length) {
            return currSum == target ? 1 : 0;
        }
        
        if (dp[idx][currSum + offset] != -1) return dp[idx][currSum + offset];

        int add = targetSumMem(arr, target, idx + 1, currSum + arr[idx], dp, offset);
        int sub = targetSumMem(arr, target, idx + 1, currSum - arr[idx], dp, offset);

        dp[idx][currSum + offset] = add + sub;
        return dp[idx][currSum + offset];
    }

    // Optimal approach using the total subsets 
    public static int totalSubsets(int arr[],int idx,int target){
        int n = arr.length;
        int[] prev = new int[target + 1];
        // base case: only one way to make sum 0 (pick nothing)
        prev[0] = 1;
        if (arr[0] <= target) prev[arr[0]] = 1;
        for (int i = 1; i < n; i++) {
            int[] curr = new int[target + 1];
            curr[0] = 1;
            for (int sum = 0; sum <= target; sum++) {
                int notpick = prev[sum];
                int take = 0;
                if (arr[i] <= sum) take = prev[sum - arr[i]];
                curr[sum] = notpick + take;
            }
            prev = curr;
        }
        return prev[target];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        int target = 3;
        // int max = 0;
        // for (int num : arr) max += num;

        // int offset = max;  
        // int[][] dp = new int[arr.length][2 * max + 1];  
        // for (int[] row : dp) Arrays.fill(row, -1);

        // int result = targetSumMem(arr, target, 0, 0, dp, offset);
        // System.out.println("Number of ways for the target sum: " + result);

        // Calling the total subsets function
        int totalWays = totalSubsets(arr, arr.length - 1, target);
        System.out.println("Total number of ways to achieve the target sum: " + totalWays);
    }
}


