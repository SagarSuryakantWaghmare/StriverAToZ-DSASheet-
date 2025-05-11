import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraphInBFS {
    // Using the topoSort Algo
    public static boolean bfsGraph(int v,ArrayList<ArrayList<Integer>> adj){
        int count=0;
        // Calculate indegree
        int indegree[]=new int[v];
        for (int i = 0; i < v; i++) {
            if(indegree[i]==0){
                indegree[i]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node=q.poll();
            count++;
            for (int  i : adj.get(node)) {
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        return count!=v;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int v=5;
        for (int i = 0; i < v; i++) {
          adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(5);
        adj.get(3).add(4);
        adj.get(4).add(2);
        System.out.println("Is Cycle Present in Directed Graph:"+bfsGraph(v,adj));
    }
}
