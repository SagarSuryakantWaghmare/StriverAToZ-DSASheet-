import java.util.*;
public class FrogJump{
    public static int countWays(int idx,int[]heights,int[]dp){
        if(idx==0) return 0;
        if(dp[idx]!=0) return dp[idx];
        int left = countWays(idx-1, heights, dp)+Math.abs(heights[idx]-heights[idx-1]);
        int right = Integer.MAX_VALUE;
        if(idx>1) {
            right = countWays(idx-2, heights, dp)+Math.abs(heights[idx]-heights[idx-2]);
        }
        return dp[idx] = Math.min(left, right);
    }
    public static void main(String[] args) {
        int heights[] = {20, 30, 40, 20};
        int n=heights.length;
        
        int dp[]=new int[n+1];
        Arrays.fill(dp, 0);
        System.out.println(countWays(n-1,heights,dp));

    }
}