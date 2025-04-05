import java.util.ArrayList;

public class GraphRepresentation {
   public static void main(String[] args) {
    // Input is n-nodes and m-edges
    // so we declare the array of the n+1 and m+1 to store the adj


    // Way:1- Matrix way
    /* 
    int n=3;
    int m=3;
    int adj[][]=new int[n+1][n+1];
    // edge1--2
    adj[1][2]=1;
    adj[2][1]=1;

    // edge 2--3
    adj[2][3]=1;
    adj[3][2]=1;

    // edge 1--3
    adj[1][3]=1;
    adj[3][1]=1;
    */

    // We store the u and v 
    // adj[u][v]=1;
    // adj[v][u]=1;
    // but there are disadvantage 
    // It cost to much to store in this way

    // So we use the arraylist
    int n=3;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<=n;i++){
        adj.add(new ArrayList<Integer>());
    }

    // Edge 1--2
    adj.get(1).add(2);
    adj.get(2).add(1);

    // adj.get(u).add(v);
    // adj.get(v).add(u);

    // Edge 2--3
    adj.get(2).add(3);
    adj.get(3).add(2);

    // Edge 1--3
    adj.get(1).add(3);
    adj.get(3).add(1);

    // Print all the edges
    for(int i=1;i<n;i++){
        for(int j=0;j<adj.get(i).size();j++){
            System.out.println(adj.get(i).get(j)+" ");
        }
        System.out.println();
    }


    // Weighted Graph?

    // So we have to store the weighted Graphes

    // So use the data Structure to store it the weight and the pairs
    




    
   } 
}
