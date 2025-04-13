import java.nio.channels.Pipe;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static void printArr(int [][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int numberOfEnclaves(int[][]grid){
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0||j==0||i==n-1||j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i, j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int dx[]={-1,0,1,0};
        int dy[]={0,-1,0,1};
        while (!q.isEmpty()) {
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow=row+dx[i];
                int ncol=col+dy[i];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                 if(grid[i][j]==1&&vis[i][j]==0){
                    count++;
                 }
            }
        }
        return count;
    }

    public static void main(String[] args) {
      int grid[][]={
        {0,0,0,1,1},
        {0,0,1,1,0},
        {0,1,0,0,0},
        {0,1,1,0,0},
        {0,0,0,1,1}
      };
      printArr(grid);
      System.out.println("Number of enclaves:"+numberOfEnclaves(grid));

    }
}
