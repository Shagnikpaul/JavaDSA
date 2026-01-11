package dsa.graphs;


import java.util.ArrayList;
import java.util.Arrays;

class DisjointSet {
    int[] rank;
    int[] parent;

    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void ranks() {
        System.out.println(Arrays.toString(rank));
    }

    public int findParent(int u) {
        if (this.parent[u] == u) {
            return u;
        } else {
            parent[u] = findParent(parent[u]);
            return parent[u];
        }
    }

    public void unionByRank(int u, int v) {
        if (parent[u] == parent[v]) {
            return;
        }
        int pu = parent[u];
        int pv = parent[v];
        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

public class NoOfOperationsToMakeNetworkConnected {


    public int makeConnected(int n, int[][] connections) {
        DisjointSet d = new DisjointSet(n);
        int redundantConnections = 0;
        for (int[] x : connections) {
            if (d.findParent(x[0]) == d.findParent(x[1]))
                redundantConnections++;
            else
                d.unionByRank(x[0], x[1]);
        }
        System.out.println("Excess connections : " + redundantConnections);
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (p.contains(d.findParent(i))) {
            } else
                p.add(d.findParent(i));
        }
        System.out.println("Total componenets " + p.size());
        return 0;
    }

    public static void main(String[] args) {
        NoOfOperationsToMakeNetworkConnected obj = new NoOfOperationsToMakeNetworkConnected();
        int n = 4;

        int[][] connections = {
                {0, 1},
                {0, 2},
                {1, 2}
        };


        obj.makeConnected(n, connections);
    }
}
