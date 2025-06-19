public class FibonacciNumber {
    // memoization approach
    // public static int dp(int n,int []dp){
    //     if(n<=1){
    //         return n;
    //     }
    //     if(dp[n]!=-1) return dp[n];
    //     return dp[n]=dp(n-1, dp)+dp(n-2,dp);
    // }

    // Tabulation approach
    // public static int dp(int n,int dp[]){
    //     dp[0]=0;
    //     dp[1]=1;
    //     for(int i=2;i<=n;i++){
    //         dp[i]=dp[i-1]+dp[i-2];
    //     }
    //     return dp[n];
    // }


    // Optimization
    public static int dp(int n){
        if(n<=1){
            return n;
        }
        int prev2=0;
        int prev=1;
        for(int i=2;i<=n;i++){
            int curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }


    public static void main(String[] args) {
        int n=4;
        // int dp[]=new int[n+1];
        // for (int i = 0; i < dp.length; i++) {
        //     dp[i]=-1;
        // }
        // int ans=dp(n,dp);

        int ans=dp(n);
        System.out.println(ans);
    }
}