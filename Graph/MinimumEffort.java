import java.util.PriorityQueue;

public class MinimumEffort {

    static class Tuple {
        int distance;
        int row;
        int col;
        public Tuple(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }
    // We just have to store in the queue in the form of the distance row and col

    public static int minimumEffort(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Tuple it = pq.poll();
            int diff = it.distance;
            int row = it.row;
            int col = it.col;

            if (row == n - 1 && col == m - 1) return diff;

            for (int i = 0; i < 4; i++) {
                int newR = row + dr[i];
                int newC = col + dc[i];

                if (newR >= 0 && newC >= 0 && newR < n && newC < m) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newR][newC]), diff);
                    if (newEffort < dist[newR][newC]) {
                        dist[newR][newC] = newEffort;
                        pq.add(new Tuple(newEffort, newR, newC));
                    }
                }
            }
        }

        return 0; 
    }

    public static void main(String[] args) {
        int[][] heights = {
            {1, 2, 2},
            {3, 8, 2},
            {5, 3, 5}
        };

        int result = minimumEffort(heights);
        System.out.println("Minimum Effort Path: " + result);
    }
}
