import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class EventualSafeStatesTopoSort {

    public static void addEdges(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static ArrayList<Integer> ESSTopoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        // Step 1: Create reversed adjacency list
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            revAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int node : adj.get(i)) {
                revAdj.get(node).add(i); // reverse the edge
            }
        }

        // Step 2: Compute in-degree of reversed graph
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int node : revAdj.get(i)) {
                inDegree[node]++;
            }
        }

        // Step 3: Topological sort using Kahn's algorithm
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int it : revAdj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Step 4: Sort the safe states
        Collections.sort(topo); // to get them in order
        return topo;
    }

    public static void main(String[] args) {
        int v = 8; // Increased to 8 to handle node 7
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdges(adj, 4, 5);
        addEdges(adj, 2, 5);
        addEdges(adj, 0, 2);
        addEdges(adj, 0, 1);
        addEdges(adj, 7, 1);
        addEdges(adj, 1, 3);
        addEdges(adj, 3, 0);
        addEdges(adj, 1, 2);

        ArrayList<Integer> res = ESSTopoSort(v, adj);
        System.out.println("Eventual safe states using Topo Sort: " + res);
    }
}
