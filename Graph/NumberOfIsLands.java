import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsLands {
    public static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static void bfs(int ro,int co,int[][]vis,char[][] grid){
        vis[ro][co]=1; 
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(ro, co));
        int n=grid.length;
        int m=grid[0].length;
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            for(int delRow=-1;delRow<=1;delRow++){
                for(int delCol=-1;delCol<=1;delCol++){
                    int nRow=row+delRow;
                    int nCol=col+delCol;
                    if(nRow>=0 &&nRow<n &&nCol>=0 && nCol<m && grid[nRow][nCol]=='1'&& vis[nRow][nCol]==0){
                        vis[nRow][nCol]=1;
                        q.add(new Pair(nRow,nCol));
                    }
                }
            }
        }
    }
    public static int numIsLands(char[][]grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }


    public static void printGrid(char[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
            System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '1'},
            {'1', '1', '0', '1', '1'}
        };
        System.out.println("Original grid:");
        printGrid(grid);
        System.out.println("Number of islands: " + numIsLands(grid));   


        
    }
}
