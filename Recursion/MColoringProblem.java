import java.util.*;

public class MColoringProblem {
    public static boolean isSafe(int node, List<Integer>[] G, int[] color, int n, int col) {
        for (int it : G[node]) {
            if (color[it] == col) return false;
        }
        return true;
    }

    public static boolean solve(int node, List<Integer>[] G, int[] color, int n, int m) {
        if (node == n) return true;
        for (int i = 1; i <= m; i++) {
            if (isSafe(node, G, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, G, color, n, m)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    public static boolean graphColoring(List<Integer>[] G, int[] color, int m) {
        int n = G.length;
        return solve(0, G, color, n, m);
    }

    public static void main(String[] args) {
        int V = 4; // number of vertices
        int m = 3; // number of colors

        // Initialize graph as an adjacency list
        List<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Define edges (undirected graph)
        graph[0].add(1);
        graph[1].add(0);

        graph[1].add(2);
        graph[2].add(1);

        graph[2].add(3);
        graph[3].add(2);

        graph[3].add(0);
        graph[0].add(3);

        graph[0].add(2);
        graph[2].add(0);

        int[] color = new int[V]; // initialize all colors to 0

        if (graphColoring(graph, color, m)) {
            System.out.println("Graph can be colored with " + m + " colors.");
            System.out.println("Color assignment:");
            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + " ---> Color " + color[i]);
            }
        } else {
            System.out.println("Graph cannot be colored with " + m + " colors.");
        }
    }
}
