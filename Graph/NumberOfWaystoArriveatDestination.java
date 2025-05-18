import java.util.*;


public class NumberOfWaystoArriveatDestination {
    public static class Pair{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static int countPaths(int n,List<List<Integer>> roads){
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=roads.size();
        for (int i = 0; i < m; i++) {
            adj.get(roads.get(i).get(0))
            .add(new Pair(roads.get(i).get(1),roads.get(i).get(2)));
            adj.get(roads.get(i).get(1))
            .add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.second-b.second);
        int []dist=new int[n];
        int []ways=new int[n];
        for (int i = 0; i < n; i++) {
            dist[i]=(int)1e9;
            ways[i]=0;
        }
        dist[0]=0;
        ways[0]=1;
        pq.add(new Pair(0, 0)); // node, distance
        int mod=(int)(1e9+7);
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.first;
            int dis = current.second;
            
            // If we've found a longer path to this node, skip
            if (dis > dist[node]) continue;
            
            for(Pair it:adj.get(node)){
                int adjNode=it.first;
                int edw=it.second;
                
                // If we found a shorter path
                if(dis+edw<dist[adjNode]){
                    dist[adjNode]=dis+edw;
                    ways[adjNode]=ways[node];
                    pq.add(new Pair(adjNode, dis+edw));
                }
                // If we found an equally short path
                else if(dis+edw==dist[adjNode]){
                    ways[adjNode]=(ways[adjNode]+ways[node])%mod;
                }
            }
        }
        return ways[n-1];
    }
    
    public static void main(String[] args) {
        int n = 7;
        List<List<Integer>> roads = new ArrayList<>();
        // Format: [from, to, time]
        roads.add(Arrays.asList(0, 6, 7));
        roads.add(Arrays.asList(0, 1, 2));
        roads.add(Arrays.asList(1, 2, 3));
        roads.add(Arrays.asList(1, 3, 3));
        roads.add(Arrays.asList(6, 3, 3));
        roads.add(Arrays.asList(3, 5, 1));
        roads.add(Arrays.asList(6, 5, 1));
        roads.add(Arrays.asList(2, 5, 1));
        roads.add(Arrays.asList(0, 4, 5));
        roads.add(Arrays.asList(4, 6, 2));
        
        int result = countPaths(n, roads);
        System.out.println("Number of ways to reach destination: " + result);
    }
}
