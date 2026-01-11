package dsa.graphs;

import java.util.*;

public class TopologicalSort {


    public static void dfs(int src, Map<Integer, ArrayList<Integer>> adj, int[] vis, Stack<Integer> s) {
        vis[src] = 1;
        for (int i : adj.get(src)) {
            if (vis[i] == -1)
                dfs(i, adj, vis, s);
        }
        s.add(src);
    }

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

        adj.put(0, new ArrayList<>(Arrays.asList(1, 2)));
        adj.put(1, new ArrayList<>(Arrays.asList(2, 3)));
        adj.put(2, new ArrayList<>(Arrays.asList(5)));
        adj.put(3, new ArrayList<>(Arrays.asList(0)));
        adj.put(4, new ArrayList<>(Arrays.asList(5)));
        adj.put(5, new ArrayList<>()); // empty
        adj.put(6, new ArrayList<>()); // empty

        Stack<Integer> s = new Stack<>();
        int[] vis = new int[adj.size()];
        Arrays.fill(vis, -1);


        for (int i = 0; i < adj.size(); i++) {
            if (vis[i] == -1) {
                dfs(i, adj, vis, s);
            }
        }
        // pop them to get in order
        while (!s.isEmpty())
            System.out.print(s.pop() + ", ");
    }
}
