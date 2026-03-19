package acc2_cat2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class TopoSort {


    public void dfs(Stack<Integer> st, int node, int[] vis, HashMap<Integer, ArrayList<Integer>> adj) {
        if (vis[node] == 1) {
            return;
        }
        for (int n : adj.get(node)) {
            dfs(st, n, vis, adj);
        }
        vis[node] = 1;
        st.add(node);
    }


    public void topo(HashMap<Integer, ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (vis[i] == 0) {
                dfs(st, i, vis, adj);
            }
        }
        System.out.println("Top SOrt");
        while (!st.isEmpty()) {
            System.out.print(st.peek() + " ");
            st.pop();
        }
    }


    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        adj.put(0, new ArrayList<>(Arrays.asList(1, 2)));
        adj.put(1, new ArrayList<>(Arrays.asList(3, 4)));
        adj.put(2, new ArrayList<>(Arrays.asList(4)));
        adj.put(3, new ArrayList<>(Arrays.asList(5)));
        adj.put(4, new ArrayList<>(Arrays.asList(5)));
        adj.put(5, new ArrayList<>());
        new TopoSort().topo(adj);
    }
}
