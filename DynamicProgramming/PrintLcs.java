public class PrintLcs {
  public static int pritnlcs(String s1, String s2) {
    int n1 = s1.length();
    int n2 = s2.length();
    int dp[][] = new int[n1 + 1][n2 + 1];
    for (int i = 1; i <= n1; i++) {
      for (int j = 1; j <= n2; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    // for (int i = 0; i < dp.length; i++) {
    // for (int j = 0; j < dp[0].length; j++) {
    // System.out.print(dp[i][j]+" ");
    // }
    // System.out.println();
    // }
    /*
     * 0 0 0 0 0 0
     * 0 0 0 0 0 0
     * 0 1 1 1 1 1
     * 0 1 1 1 1 1
     * 0 1 2 2 2 2
     * 0 1 2 2 3 3
     */
    StringBuilder lcs=new StringBuilder();
    int i=n1,j=n2;
    while (i>0&&j>0) {
      if(s1.charAt(i-1)==s2.charAt(j-1)){
        lcs.append(s1.charAt(i-1));
        i--;
        j--;
      }
      else if(dp[i-1][j]>dp[i][j-1]){
        i--;
      }
      else{
        j--;
      }
    }
    System.out.println("String of the lcs:"+lcs.reverse());
    
    return dp[n1][n2];
  }

  public static void main(String[] args) {
    String s1 = "abcde";
    String s2 = "bdgek";
    System.out.println("longest common subsequnce :" + pritnlcs(s1, s2));
  }
}
