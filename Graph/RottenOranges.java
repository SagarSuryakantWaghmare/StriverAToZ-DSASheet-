import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static class Pair {
        int row;
        int col;
        int tn;

        Pair(int row, int col, int tn) {
            this.row = row;
            this.col = col;
            this.tn = tn;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int countFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) countFresh++;
            }
        }

        int tn = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int count = 0;

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tn;
            tn = Math.max(tn, t);
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }

        if (count != countFresh) return -1;
        return tn;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = orangesRotting(grid);
        if (result == -1) {
            System.out.println("Not all oranges can rot.");
        } else {
            System.out.println("Time taken for all oranges to rot: " + result);
        }
    }
}
