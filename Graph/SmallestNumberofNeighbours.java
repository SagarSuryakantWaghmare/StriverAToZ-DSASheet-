public class SmallestNumberofNeighbours {

    public static int findCity(int n, int m, int edges[][], int distanceThreshold) {
        int[][] dist = new int[n][n];

        // Initialize distances
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }

        // Fill in the initial edge distances
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Floyd-Warshall Algorithm to compute all-pairs shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // Find the city with the smallest number of reachable cities within the threshold
        int cntCity = Integer.MAX_VALUE;
        int cityMo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (city != adjCity && dist[city][adjCity] <= distanceThreshold) {
                    cnt++;
                }
            }
            // If two cities have the same count, return the one with the greater index
            if (cnt <= cntCity) {
                cntCity = cnt;
                cityMo = city;
            }
        }
        return cityMo;
    }

    public static void main(String[] args) {
        /*
         * Example graph:
         * Number of cities = 4
         * Edges = [ [0, 1, 3], [1, 2, 1], [2, 3, 4], [0, 3, 7] ]
         * Distance threshold = 4
         */

        int n = 4; // number of cities
        int m = 4; // number of edges
        int[][] edges = {
            {0, 1, 3},
            {1, 2, 1},
            {2, 3, 4},
            {0, 3, 7}
        };
        int distanceThreshold = 4;

        int result = findCity(n, m, edges, distanceThreshold);
        System.out.println("The city with the smallest number of neighbours within the threshold is: " + result);
    }
}
