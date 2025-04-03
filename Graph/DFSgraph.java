import java.util.ArrayList;

public class DFSgraph {
    // At given starting node we have to go for the dfs traversal
    // After in the both the position we have to check if the node is already
    // visited or not
    // If not then we have to mark it as visited and add it to the list
    // Then we have to go for the next node in the adjacency list of the current
    // node
    // If the node is already visited then we have to skip it and go for the next
    // node in the adjacency list of the current node
    // We have to do this for all the nodes in the adjacency list of the current
    // node
    // After that we have to return the list of nodes in the order they are visited
    // We have to do this for all the nodes in the graph

    public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        vis[node] = true;
        ls.add(node);
        // Getting neighbour nodes of the current node
        for (Integer it : adj.get(node)) {
            // If the node is not visited then we have to go for the dfs traversal
            if (vis[it] == false) {
                dfs(it, vis, adj, ls);
            }
        }
    }

    // Function to return a list containing the dfs traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v + 1];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 5;
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(2).add(4);

        DFSgraph dfsGraph = new DFSgraph();
        ArrayList<Integer> dfsResult = dfsGraph.dfsOfGraph(v, adj);

        System.out.println("DFS Traversal:");
        for (int node : dfsResult) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}