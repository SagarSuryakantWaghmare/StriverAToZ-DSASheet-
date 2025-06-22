import java.util.*;
public class FrogJumpKDistance {
    // public static int solve(int idx,int[]heights,int[]dp,int k){
    //     if(idx==0){
    //         return 0;
    //     }
    //     if(dp[idx]!=-1){
    //         return dp[idx];
    //     }

    //     int mmSteps=Integer.MAX_VALUE;
    //     for(int j=1;j<=k;j++){
    //         if(idx-j>=0){
    //             int jump=solve(idx-j, heights, dp, k)+Math.abs(heights[j]-heights[idx-j]);
    //             mmSteps=Math.min(jump, mmSteps);
    //         }
    //     }
    //     return dp[idx]=mmSteps;
    // }

    static int solve(int n, int[] height, int[] dp, int k) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1]; // The result is stored in the last element of dp
    }
    public static int findMin(int n,int[]heights,int k){
        int []dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,heights,dp,k);
    }

    public static void main(String[] args) {
        int heights[] = { 30, 10, 60, 10, 60, 50 };
        int  k = 2;
        int n = heights.length;
        // Memoization
        System.out.println(findMin(n,heights,k));
    }
}