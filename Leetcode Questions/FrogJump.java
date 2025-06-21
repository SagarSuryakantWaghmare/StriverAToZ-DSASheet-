import java.util.Arrays;

public class FrogJump {
    public static int countWays(int idx,int heights[],int[]dp){
        // Memoization
        // if(idx==0){
        //     return 0;
        // }
        // if(dp[idx]!=-1) return dp[idx];
        // int left=countWays(idx-1, heights, dp)+Math.abs(heights[idx]-heights[idx-1]);
        // int right=Integer.MAX_VALUE;
        // if(idx>1) right=countWays(idx-2, heights, dp)+Math.abs(heights[idx]-heights[idx-2]);
        // return Math.min(left, right);

        // Tabulizaton
        dp[0]=0;
        int n=heights.length;
        for(int i=1;i<n;i++){
            int left=dp[i-1]+Math.abs(heights[i]-heights[i-1]);
            int right=Integer.MAX_VALUE;
            if(i>1){
               right=dp[i-2]+Math.abs(heights[i]-heights[i-2]);
            }
            dp[i]=Math.min(left,right);

        }
        return dp[n-1];
        

    }

    public static void main(String[] args) {
        int heights[] = {20, 30, 40, 20};
        int n=heights.length;
        
        int dp[]=new int[n+1];
        System.out.println(countWays(n-1,heights,dp));

    }
}