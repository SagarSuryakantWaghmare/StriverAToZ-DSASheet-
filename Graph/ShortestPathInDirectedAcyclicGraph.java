import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {

    static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for (Pair it : adj.get(node)) {
            if (vis[it.node] == 0) {
                topoSort(it.node, adj, vis, st);
            }
        }
        st.push(node);
    }

    public static int[] shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();

            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair it : adj.get(node)) {
                    if (dist[node] + it.weight < dist[it.node]) {
                        dist[it.node] = dist[node] + it.weight;
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int N = 7; // number of nodes
        int M = 8; // number of edges
        int[][] edges = {
            {0, 1, 2},
            {0, 2, 1},
            {1, 3, 3},
            {2, 3, 3},
            {4, 0, 3},
            {4, 1, 1},
            {5, 4, 2},
            {6, 5, 3}
        };

        int[] result = shortestPath(N, M, edges);

        System.out.println("Shortest distances from node 0:");
        for (int i = 0; i < result.length; i++) {
            System.out.print((result[i] == Integer.MAX_VALUE ? "INF" : result[i]) + " ");
        }
    }
}
