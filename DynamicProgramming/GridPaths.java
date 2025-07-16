import java.util.Arrays;

public class GridPaths {
    // count paths
    // count paths with the obstacles
    // Min path sum
    // Max path sum
    // Triangle
    // 2 start points

    // Total Unique Paths

    // You are present a point 'A' which is the top-left cell of a matrix.
    // so you have to go the point 'B' to the bottom-right cell of a matrix.
    // Unique Paths
    /*
     * There is the matrix of 2*2
     * (0,0)->(1,1)
     * 
     * 2D-grid
     * so are going from the 0,0 to n-1,m-1
     * How to write recurrence?
     * 1.Express no terms of index(i,j)(row,col)
     * 2.Explore/Do all stuffs
     * 3. Sum up all ways|max/min
     */
    // public static int countWays(int i, int j) {
    //     if (i < 0 || j < 0)
    //         return 0;
    //     if (i == 0 && j == 0)
    //         return 1;
    //     int up = countWays(i - 1, j);
    //     int left = countWays(i, j - 1); 
    //     return up + left;
    // }

    // Memoization:Overlapping occurs
    // TC->O(n*m)
    // Sc->)(n-1)+(m-1)+O(n*m)
    public static int countWays(int i,int j,int dp[][]){
        if(i<0||j<0) return 0;
        if(i==0&&j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=countWays(i-1, j, dp);
        int up=countWays(i, j-1, dp);
        return dp[i][j]=left+up;
    }

    // Tabulazation way
    public static int countWaysTab(int n,int m){
     // Create a dp with with size of n*m
        // Bottom up
        // We start form the base case so that's why we called as the bottom up
        int dp[][]=new int[n][m];
        dp[0][0]=1;
        // Declare base case
        // Express all states in for loop
        // Copy the recurrence and write
        for(int i=0;i<=m-1;i++){
            for(int j=0;j<=n-1;j++){
              if(i==0&&j==0) dp[0][0]=1;
              else{
                int up=0;
                int left=0;
                if(j>0)  up=dp[i][j-1];
                if(i>0)  left=dp[i-1][j];
                dp[i][j]=up+left;
              }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        // Recursion:o(2^n*m) each of the giving the n*m
        // top down approach
        // count ways to go from the 0,0 to n-1,m-1
        // f(i,j) -> no of unique ways
        // Base case
        // return 1 or return 0
        // up=f(i-1,j)
        // left=f(i,j-1)
        // return up+left;
        // System.out.println(countWays(1, 1));

        // count ways in the memoization
        // int n=3;
        // int m=3;
        // int dp[][]=new int[n+1][m+1];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         dp[i][j]=-1;
        //     }
        // }
        // System.out.println(countWays(n-1,m-1,dp));

        // countWays in the tabulazation
        // System.out.println("count Ways:"+countWaysTab(3, 3));

        // Space optimization way
    }
}
