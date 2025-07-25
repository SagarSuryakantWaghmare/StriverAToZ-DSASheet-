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
        // Recursion:TC :O(2^n)
        // SC:O(n) Auxillary space complexity
    }
    // Memoization
    public static int totalSubsets(int arr[],int idx,int target,int[][]dp){
        if(idx==0) return target==arr[0]?1:0;
        if(target==0) return 1;
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notpick=totalSubsets(arr, idx-1, target, dp);
        int pick=0;
        if(arr[idx]<=target)pick=totalSubsets(arr, idx-1, target-arr[idx], dp);
        return dp[idx][target]=pick+notpick;
    }

    public static int totalSubsetsTab(int arr[],int idx,int target){
        int n=arr.length;
        // Base case
        // look at the changing the paramters and write nexted loops
        // Copy the recursions
        int dp[][]=new int[n][target+1];
        for(int i=0;i<n;i++) dp[i][0]=1;
        if(arr[0]<=target) dp[0][arr[0]]=1;
        // write the for loop for the both changing parameters
        // index and target both are  changing 
        // Write a loop form the i =>1 to n-1
        // For the s->0 to target
        // So we can now make the loop 
        for(int i=1;i<n;i++){
            for(int sum=0;sum<=target;sum++){
                 int notpick=dp[i-1][sum];
                 int take=0;
                 if(arr[i]<=sum) take=dp[i-1][sum-arr[i]];
                 dp[i][sum]=notpick+take;       
            }
        }
        return dp[n-1][target];
    }
    // Space optimization
    public static int totalSubsetsSpaceOpt(int arr[],int idx,int target){
        int n=arr.length;
        int prev[]=new int[target+1];
        int curr[]=new int[target+1];
        // Base case
        for(int i=0;i<n;i++) prev[0]=1;
        if(arr[0]<=target) prev[arr[0]]=1;
        // Write the loop for the changing parameters
        for(int i=1;i<n;i++){
            for(int sum=0;sum<=target;sum++){
                int notpick=prev[sum];
                int take=0;
                if(arr[i]<=sum) take=prev[sum-arr[i]];
                curr[sum]=notpick+take;       
            }
            // Copy the current to previous
            for(int j=0;j<=target;j++) prev[j]=curr[j];
        }
        return prev[target];
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