public class PartitionArrayForMaximumSum {
    public static int maximumSumAfterPartitioning(int[]arr,int k){
        //recursion
        // return helper(arr,k,0);

        // Memoization way
        // int n=arr.length;
        // int[]dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return helperMem(arr,k,0,dp);

        // Tabulazation way
        return helperTab(arr,k);

    }
    public static int helperTab(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int currMax = 0;
            int maxSum = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                currMax = Math.max(currMax, arr[i - j]);
                maxSum = Math.max(maxSum, dp[i - j] + currMax * j);
            }
            dp[i] = maxSum;
        }
        return dp[n];
    }
    public static int helperMem(int []arr,int k,int idx,int []dp){
        int n=arr.length;
        if(idx==n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int maxSum=0;
        int currMax=0;
        for(int i=1;i<=k&&idx+1-1<n;i++){
            currMax=Math.max(currMax,arr[idx+i-1]);
            maxSum=Math.max(maxSum,currMax*i+helperMem(arr,k,idx+i,dp));
        }
        return dp[idx]=maxSum;
    }

    public static int helper(int[]arr,int k,int idx){
        int n=arr.length;
        if(idx==n) return 0;
        int maxSum=0;
        int currMax=0;
        for(int i=1;i<=k && idx+i-1<n;i++){
            currMax=Math.max(currMax,arr[idx+i-1]);
            maxSum=Math.max(maxSum,currMax*i+helper(arr,k,idx+i));
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        System.out.println(maximumSumAfterPartitioning(arr, k));
    }
}