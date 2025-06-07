import java.util.*;

class Disjoint {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        if (ulp_u == ulp_v)
            return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        if (ulp_u == ulp_v)
            return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

public class DisjointSet {
    // Finding parent or finding union
    // Finding union()-rank and size
      public static void main(String[] args) {
        Disjoint ds = new Disjoint(8); // Changed from 7 to 8 to accommodate indices 0-7

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // Check if 3 and 7 belong to same component
        if(ds.findPar(3) == ds.findPar(7)) {
            System.out.println("Same component");
        } else {
            System.out.println("Not same component");
        }

        ds.unionByRank(3, 7);

        if(ds.findPar(3) == ds.findPar(7)) {
            System.out.println("Same component");
        } else {
            System.out.println("Not same component");
        }
    }
}