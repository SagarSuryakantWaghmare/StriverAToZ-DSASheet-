import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithmBFSTopologicalSort {
    /*
     * Vertices such that if there is an edge between u and v
     * u appears before v in the ordering
     * 
     * Note:Only valid on DAG
     * Cannnot valid for the :
     * 1.Directed Graph
     * 2.Cyclic Graph
     */

    //  Here we are doing topo sort using the bfs
    // We are using the queue Data Structure
    // No of oncoming edges to a node

    // so we inserted all the nodes with indegree zero
    public static int[] kahnSort(int v,ArrayList<ArrayList<Integer>> adj){
        int indegree[]=new int[v];
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<Integer>();
        for (int i = 0; i < v; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int topo[]=new int[v];
        int i=0;
        while (!q.isEmpty()) {
            int node=q.peek();
            q.remove();
            topo[i++]=node;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return topo;
    }



    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 6; 
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges as per the graph
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        int res[]=kahnSort(V, adj);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
