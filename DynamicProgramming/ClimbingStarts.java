public class ClimbingStarts {
    public static int countWays(int n){
        if(n==0){
            return 1;
        }
        if(n==1) return 0;
        // Count all ways
        int left=countWays(n-1);
        int right=countWays(n-2);
        return left+right;
    }
    // Memoziation
    // public static int  countWays(int n,int[]dp){
    //     if(n==0){
    //         return 1;
    //     }
    //     if(n==1) return 0;
    //     if(dp[n]!=-1) return dp[n];
    //     return dp[n]=countWays(n-1,dp)+countWays(n-2,dp);

    // }

    // Tabulaztion form 
    // public static int countWays(int n,int[]dp){
    //     dp[0]=1;
    //     dp[1]=0;
    //     for(int i=2;i<=n;i++){
    //         dp[i]=dp[i-1]+dp[i-2];
    //     }
    //     return dp[n];
    // }



    // Space optimization
    public static int countWays(int n,int [] dp){
        int prev2=1;
        int prev=0;
        for(int i=2;i<=n;i++){
            int curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static void main(String[] args) {
      // Understand a dp problem
      // You are climbing a staircase. It takes n steps to reach the top.
        // Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
        int n = 4; // Number of steps
        // Try all possible ways 
        // Count and best way


        // Then we apply the recursion
        // Try to represent the problem in terms of index
        // Do all possible stuffs on that and all of the problem start amunt
        // Sum of all stuffs -> Count all ways
        // min(of all stuffs) -> for min

        // int ans = countWays(n);
        int dp[]=new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=-1;
        }
        int ans=countWays(n,dp);
        System.out.println(ans);
    }
}
