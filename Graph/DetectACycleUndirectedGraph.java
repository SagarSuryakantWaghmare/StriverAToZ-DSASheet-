import java.util.*;
import java.util.Queue;


public class DetectACycleUndirectedGraph {
    public static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            // parent
            this.second=second;
        }
    }
    // Some are using the bfs here to detect the cycle
    public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static boolean checkForCycle(int src,int v,ArrayList<ArrayList<Integer>> adj,boolean[]vis){
        vis[src]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src, -1));
        while (!q.isEmpty()) {
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int adjNode:adj.get(node)){
                if(vis[adjNode]==false){
                    vis[adjNode]=true;
                    q.add(new Pair(adjNode, node));
                }
                else if(parent!=adjNode){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycle(int v,ArrayList<ArrayList<Integer>> adj){
        boolean vis[]=new boolean[v];
        for (int i = 0; i < v; i++) {
            vis[i]=false;
        }
        for (int i = 0; i < v; i++) {
            if(vis[i]==false){
                if(checkForCycle(i,v,adj,vis)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
       int v=5;
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for (int i = 0; i < v; i++) {
        adj.add(new ArrayList<>());
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 1);
        System.out.println("Cycle Detected:"+isCycle(v,adj));
       } 
    }
}
