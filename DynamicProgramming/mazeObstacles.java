public class mazeObstacles {
    // So we have to from the top -left to right-bottom
    /*
     * 0 0 0
     * 0 -1 0
     * 0 0 0
     * so there is the obstacles between shown by the -1
     * 
     */
    // so there is the dead cell
    // mat[i][j]=-1 then it is dead cell
    // We cann't go from this cell
    // So we add one more base case for the dead cell
    public static int countWays(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int dp[][]=new int[n][m];
        dp[0][0]=1;
        for(int i=0;i<=m-1;i++){
            for(int j=0;j<=n-1;j++){
                int left=0;
                int up=0;
                if(mat[i][j]==-1) dp[i][j]=0;
                else if(i==0&&j==0) dp[i][j]=1;
                else{
                   if(i>0) up=dp[i-1][j];
                   if(j>0) left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[n-1][m-1];
    }
    public static  void main(String[] args) {
        int mat[][] = { { 0, 0, 0 },
                { 0, -1, 0 },
                { 0, 0, 0 } };
        System.out.println(countWays(mat));
    }

}
