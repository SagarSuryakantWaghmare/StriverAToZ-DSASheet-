import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHavingOne {

    // So we have to traversal the one steps so we have to use the bfs
    public static void printArr(int [][]arr){
        int n=arr.length;
        int m=arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static class Node{
        int first;
        int second;
        int third;
        Node(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }

    }
    public static int[][] nearest(int[][]grid){
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int near[][]=new int[n][m];
        Queue<Node> q=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1){
                    vis[i][j]=1;
                    q.add(new Node(i, j, 0));
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        // So we have to go for the 4 direction
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        while (!q.isEmpty()) {
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            near[row][col]=steps;
            for (int i = 0; i < 4; i++) {
                int nrow=row+dx[i];
                int ncol=col+dy[i];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Node(nrow, ncol , steps+1));
                }
            }
        }
        return near;
    }
    public static void main(String[] args) {
        int grid[][]={
            {0,1,0},
            {1,0,0},
            {1,0,1}
        };
        System.out.println("Grid");
        printArr(grid);
        int ans[][]=nearest(grid);
        System.out.println("Nearest A grid");
        printArr(ans);


    }
}