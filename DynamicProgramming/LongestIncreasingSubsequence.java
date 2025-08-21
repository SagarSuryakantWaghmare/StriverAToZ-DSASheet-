public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
      int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
    //   Output for this example

      int n = arr.length;
      System.out.println("Length of Longest Increasing Subsequence is " + lis(arr, n));
    }
    // Recurrence
    public static int lis(int arr[],int n){
        // return rec(arr,n,0);
        // int dp[]=new int[n];
        // for(int i=0;i<n;i++){
        //     dp[i]=-1;
        // }
        // return mem(dp,arr,n,0);

        return tab(arr,n);
    }
    public static int rec(int arr[],int n,int idx){
        if(idx==n) return 1;
        int maxLength=1;
        for(int i=idx+1;i<n;i++){
            if(arr[i]>arr[idx]){
                maxLength=Math.max(maxLength,1+rec(arr,n,i));
            }
        }
        return maxLength;
    }
    public static int mem(int dp[],int arr[],int n,int idx){
        if(idx==n) return 1;
        if(dp[idx]!=-1) return dp[idx];
        int maxLength=1;
        for(int i=idx+1;i<n;i++){
            if(arr[i]>arr[idx]){
                maxLength=Math.max(maxLength,1+mem(dp,arr,n,i));
            }
        }
        return dp[idx]=maxLength;
    }
    public static int tab(int arr[],int n){
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
        }
        int maxLength=0;
        for(int i=0;i<n;i++){
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}
