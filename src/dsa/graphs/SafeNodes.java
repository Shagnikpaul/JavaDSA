package dsa.graphs;

import java.util.*;

public class SafeNodes {

    public static boolean dfs(Map<Integer, ArrayList<Integer>> adj, int[] vis, int[] isSafe, int src) {
        //System.out.println("to " + src + ((isSafe[src] == 1) ? " yes" : ""));
        vis[src] = 1;
        if (isSafe[src] == 1)
            return true;
        for (int i : adj.get(src)) {

            if (vis[i] != 1) {
                if (dfs(adj, vis, isSafe, i) == true) {
                } else {
                    vis[src] = -1;
                    //System.out.println("rejected " + src + " as safe");
                    return false;
                }
            } else {
                if (isSafe[i] == 1) {

                } else {
                    vis[src] = -1;
                    //System.out.println("rejected " + src + " as safe");
                    return false;
                }
            }


        }
        vis[src] = -1;
        isSafe[src] = 1;
        return true;
    }


    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

        adj.put(0, new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        adj.put(1, new ArrayList<>(Arrays.asList(1, 2)));
        adj.put(2, new ArrayList<>(Arrays.asList(3, 4)));
        adj.put(3, new ArrayList<>(Arrays.asList(0, 4)));
        adj.put(4, new ArrayList<>(Arrays.asList()));


        int[] isSafe = new int[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).size() == 0)
                isSafe[i] = 1;
            else
                isSafe[i] = -1;
        }
        //System.out.println(Arrays.toString(isSafe));
        int[] vis = new int[adj.size()];
        Arrays.fill(vis, -1);
        for (int i = 0; i < adj.size(); i++) {
            if (isSafe[i] == -1) {
                if (dfs(adj, vis, isSafe, i)) {
                    isSafe[i] = 1;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (isSafe[i] == 1)
                ans.add(i);
        }
        System.out.println(ans);
    }
}
