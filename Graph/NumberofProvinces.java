import java.util.ArrayList;
import java.util.List;

public class NumberofProvinces {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[]) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, adj, vis);
            }
        }
    }

    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) { // Fixed incrementing `j` instead of `i`
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int vis[] = new int[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, adjLs, vis);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Sample adjacency matrix for testing
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(1, 1, 0)));
        adj.add(new ArrayList<>(List.of(1, 1, 0)));
        adj.add(new ArrayList<>(List.of(0, 0, 1)));

        int V = adj.size();
        int result = numProvinces(adj, V);
        System.out.println("Number of Provinces: " + result);
    }
}
