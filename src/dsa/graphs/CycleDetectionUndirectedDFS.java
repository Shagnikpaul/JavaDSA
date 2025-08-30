package dsa.graphs;

import java.util.*;


public class CycleDetectionUndirectedDFS {

    public static boolean findCycleUsingDFS(HashMap<Integer, ArrayList<Integer>> adj, int[] vis, int src, int parent) {
        vis[src] = 1;
        for (int i : adj.get(src)) {
            if (!(i == parent)) {
                if (!(vis[i] == 1)) {
                    if (findCycleUsingDFS(adj, vis, i, src))
                        return true;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {


//        // graph with cycle
//        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
//        graph.put(1, new ArrayList<>(Arrays.asList(2, 3)));
//        graph.put(2, new ArrayList<>(Arrays.asList(1, 5)));
//        graph.put(3, new ArrayList<>(Arrays.asList(1, 4, 6)));
//        graph.put(4, new ArrayList<>(List.of(3)));
//        graph.put(5, new ArrayList<>(Arrays.asList(2, 7)));
//        graph.put(6, new ArrayList<>(Arrays.asList(3, 7)));
//        graph.put(7, new ArrayList<>(Arrays.asList(5, 6)));

        // graph without loop
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        graph.put(1, new ArrayList<>(Arrays.asList(2, 3)));
        graph.put(2, new ArrayList<>(Arrays.asList(1, 5)));
        graph.put(3, new ArrayList<>(Arrays.asList(1, 4, 6)));
        graph.put(4, new ArrayList<>(Arrays.asList(3)));
        graph.put(5, new ArrayList<>(Arrays.asList(2, 7)));
        graph.put(6, new ArrayList<>(Arrays.asList(3)));
        graph.put(7, new ArrayList<>(Arrays.asList(5)));

        int[] visited = new int[graph.size() + 1];
        if (findCycleUsingDFS(graph, visited, 1, -1)) {
            System.out.println("Found a cycle using DFS");
        } else {
            System.out.println("No cycle detected using DFS");
        }

    }
}
