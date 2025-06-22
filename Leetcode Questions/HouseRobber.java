import java.util.Arrays;

public class HouseRobber {
    public static int rob(int[]a){
        if(a.length == 0) return 0;
        if(a.length == 1) return a[0];
        
        int dp[] = new int[a.length];
        Arrays.fill(dp, -1);
        for(int i=0;i<a.length;i++){
            dp[i]=fn(i,a,dp);
        }
        return dp[a.length-1];
    }    public static int fn(int i, int[] a, int[] dp) {
        if(i==0) return a[0];
        if(i==1) return Math.max(a[0], a[1]);
        if(dp[i] != -1) return dp[i];
        int pick=a[i]+fn(i-2, a, dp);
        int notPick=fn(i-1, a, dp);
        return dp[i] = Math.max(pick, notPick);
    }

  public static void main(String[] args) {
    int [] nums = {2, 7, 9, 3, 1};
    System.out.println(rob(nums)); 
  }
}