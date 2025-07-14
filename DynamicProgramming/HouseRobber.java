import java.util.*;
public class HouseRobber {
    // Memoization approach:top down approach
    public static int rob(int[]nums){
        int n=nums.length;
        if(n==1) return nums[0];
        int[]dp1=new int[n];
        int[]dp2=new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        // Case 1: Rob houses from 0 to n-2
        int case1=robMemo(nums,0,n-2,dp1);
        // Case 2: Rob houses from 1 to n-1
        int case2=robMemo(nums,1,n-1,dp2);
        return Math.max(case1, case2);
    }
    public static int robMemo(int[]nums,int start,int end,int[]dp){
        if(start>end) return 0;
        if(dp[start]!=-1) return dp[start];
        int pick=nums[start]+robMemo(nums, start+2, end, dp);
        int notPick=robMemo(nums, start+1, end, dp);
        return dp[start]=Math.max(pick, notPick);
    }

    // Tabulation approach: bottom up approach
    public static int robTab(int []nums){
        int n=nums.length;
        if(n==1) return nums[0];
        int case1=robTab(nums,0,n-2);
        int case2=robTab(nums,1,n-1);
        return Math.max(case1,case2);
    }
    public static int robTab(int[]nums,int start,int end){
        int n=end-start+1;
        int[]dp=new int[n+2];
        for(int i=end;i>=start;i--){
            int idx=i-start;
            int pick=nums[i]+dp[idx+2];
            int notPick=dp[idx+1];
            dp[idx]=Math.max(pick, notPick);
        }
        return dp[0];
    }

    // space optimized approach
    public static int robSpace(int[]nums){
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int case1=robLinear(nums,0,n-2);
        int case2=robLinear(nums,1,n-1);
        return Math.max(case1, case2);
    }
    public static int robLinear(int[]nums,int start,int end){
        int prev=0;
        int curr=0;
        for(int i=start;i<=end;i++){
            int pick=nums[i]+prev;
            int notPick=curr;
            int temp=Math.max(pick,notPick);
            prev=curr;
            curr=temp;
        }
        return curr;
    }
    public static void main(String[] args) {
        // So the key idea is to use dynamic programming to solve the problem.
        int nums[]={2,3,2};
        // System.out.println(rob(nums));
        // System.out.println(robTab(nums));
        System.out.println(robSpace(nums));
        

    }

}
