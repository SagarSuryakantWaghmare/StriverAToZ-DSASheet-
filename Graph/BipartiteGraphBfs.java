import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBfs {
    // No two adjacent have the same colors
    // If you are able to color the graph just using the two colors, then the graph
    // is bipartite.
    // If you are not able to color the graph just using the two colors, then the
    // graph is not bipartite.

    // Linear cycle is a bipartite graph
    // Also the even length cycle is also a bipartite graph
    // But the odd length cycle is not a bipartite graph
    public static boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[v];
        for (int i = 0; i < v; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (check(i, color, v, adj) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean check(int start, int[] color, int v, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for (Integer it : adj.get(node)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(0);
        adj.get(3).add(1);
        adj.get(4).add(1);

        System.out.println("Is Bipartite Graph:" + isBipartite(V, adj));
    }
}
