public class PartitionAsetIntoTwoSubsetsWithMinimumAbsoluteSumDiff {
    public static int minAbsDiff(int[]arr){
        int totalSum=0;
        int l=arr.length;
        for(int n:arr)totalSum+=n;
        int target=totalSum;
        boolean dp[][]=new boolean[l+1][target+1];
        // Base case
        for(int i=0;i<=l;i++){
            dp[i][0]=true;
        }
        for(int j=1;j<=target;j++){
            dp[0][j]=false;
        }
        for(int i=1;i<=l;i++){
            for(int j=1;j<=target;j++){
               if(arr[i-1]<=j){
                dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
               }
               else{
                dp[i][j]=dp[i-1][j];
               }
            }
        }
        int mini=Integer.MAX_VALUE;
        for(int s1=0;s1<=totalSum/2;s1++){
            if(dp[l-1][s1]==true){
                mini=Math.min(mini, Math.abs((totalSum-s1)-s1));
            }
        }
        return mini;
    }
    public static void main(String[] args) {
        // Given only postive intergers
        // We have to find the partition to find the minimum
        // Absolute difference considering any valid divison of the array elements
        // [1,2,3,4]
        // [1,2] [3,4] -> 7 - 3=4
        // [1,4] [2,3]-> 5-5 =0 so this is the minimum diff
        // We already do the same thing in the previous exam
        // Just for the doing for the finding the idx to target
        // We write the take and not take the case
        // for that we do the take=false
        // Where we check the arr[idx]<=target
        // In the tabulatation we write as the for the true
        // dp[n][target]
        // for(int i=0->n-1) dp[idx][0]=true
        // for the any target the dp is equal to the zero we get answer
        // if(arr[0]<=target)dp[0][arr[0]]=true
        /*
         * for(int i=1->n-1){
         * for(target->1->k){
         * nottake=dp[i-1][target]
         * take=false;
         * if(arr[i]<=target){
         * take=dp[i-1][target-arr[i]]
         * dp[i][target]=take or nottake;
         * }
         * }}
         */
        //we can derive if every possible target between (1&k) is right /wrong
        // So for getting the min abs diff is minimum
        int arr[]={1,2,3,4};
        System.out.println(minAbsDiff(arr));

    }
}
