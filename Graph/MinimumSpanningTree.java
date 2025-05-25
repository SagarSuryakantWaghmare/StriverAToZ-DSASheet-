import java.util.*;
public class MinimumSpanningTree {
    public static int findMST(int n,int m,int[][]edges){
    Arrays.sort(edges,(a,b)->a[2]-b[2]);
    int parent[]=new int[n];
    for(int i=0;i<n;i++){
        parent[i]=i;

    }
    int rank[]=new int[n];
    for(int i=0;i<n;i++){
        rank[i]=1;
    }
    int mstWeight=0;
    for(int i=0;i<m;i++){
        int u=edges[i][0];
        int v=edges[i][1];
        int wt=edges[i][2];
        int pu=findParent(u,parent);
        int pv=findParent(v,parent);
        if(pu!=pv){
            mstWeight+=wt;
            unionByRank(pu,pv,parent,rank);
        }
    }
    return mstWeight;
}

// Find parent of a node (with path compression)
private static int findParent(int node, int[] parent) {
    if(node == parent[node]) {
        return node;
    }
    return parent[node] = findParent(parent[node], parent);
}

// Union by rank
private static void unionByRank(int u, int v, int[] parent, int[] rank) {
    if(rank[u] < rank[v]) {
        parent[u] = v;
    } else if(rank[v] < rank[u]) {
        parent[v] = u;
    } else {
        parent[v] = u;
        rank[u]++;
    }
}

    public static void main(String[] args) {
        // N nodes and m edges
        int n = 5; // Number of nodes
        int m = 6; // Number of edges
        int[][] edges = {
            {0, 1, 4},
            {0, 2, 1},
            {1, 2, 2},
            {1, 3, 5},
            {2, 3, 8},
            {3, 4, 3}
        };
        System.out.println("Minimum Spanning Tree Weight: " + findMST(n, m, edges));
    }
}
