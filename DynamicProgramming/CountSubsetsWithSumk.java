public class CountSubsetsWithSumk {
    // Recursion pick /not pick
    public static int totalSubsets(int arr[],int idx,int target){
        // Base case
        if(idx==0) return target==arr[0] ? 1 : 0;
        if(target==0) return 1;
        int notpick=totalSubsets(arr, idx-1, target);
        int pick=0;
        pick=totalSubsets(arr, idx-1, target-arr[idx]);
        return pick+notpick;
    }
    // Memoization
    public static int totalSubsets(int arr[],int idx,int target,int[][]dp){
        if(idx==0) return target==arr[0]?1:0;
        if(target==0) return 1;
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notpick=totalSubsets(arr, idx-1, target, dp);
        int pick=0;
        pick=totalSubsets(arr, idx-1, target-arr[idx], dp);
        return dp[idx][target]=pick+notpick;
    }

    public static int totalSubsetsTab(int arr[],int idx,int target){
        int n=arr.length;
        int dp[][]=new int[n][target+1];
        dp[0][0]
    }

    public static void main(String[] args) {
        int arr[]={1,2,2,3};
        int target=3;
        // System.out.println("Total number of subsets equal to target:"+totalSubsets(arr,arr.length-1,target));
        // memoization
        // int dp[][]=new int[arr.length][target+1];
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<=target;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // System.out.println("Total number of subsets equal to target:"+totalSubsets(arr,arr.length-1,target,dp));
        
        // Tabulation way:
        System.out.println("Total number of subsets equal to target:"+totalSubsetsTab(arr,arr.length-1,target));
    }
}