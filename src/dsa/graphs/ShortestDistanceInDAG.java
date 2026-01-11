package dsa.graphs;

import java.util.*;


public class ShortestDistanceInDAG {

    public static void dfs(int src, Map<Integer, ArrayList<Edge>> graph, int[] vis, Stack<Integer> s) {
        vis[src] = 1;
        for (Edge e : graph.get(src)) {
            if (vis[e.i] == -1) {
                dfs(e.i, graph, vis, s);
            }
        }
        s.add(src);
    }


    public static void main(String[] args) {
//        Map<Integer, ArrayList<Edge>> graph = new HashMap<>();
//
//        graph.put(0, new ArrayList<>(Arrays.asList(
//                new Edge(1, 2),
//                new Edge(4, 1)
//        )));
//        graph.put(1, new ArrayList<>(Arrays.asList(
//                new Edge(2, 3)
//        )));
//        graph.put(2, new ArrayList<>(Arrays.asList(
//                new Edge(3, 6)
//        )));
//        graph.put(3, new ArrayList<>()); // no outgoing edges
//        graph.put(4, new ArrayList<>(Arrays.asList(
//                new Edge(5, 4),
//                new Edge(2, 2)
//        )));
//        graph.put(5, new ArrayList<>(Arrays.asList(
//                new Edge(3, 1)
//        )));


        Map<Integer, ArrayList<Edge>> graph = new HashMap<>();

        graph.put(0, new ArrayList<>(Arrays.asList(
                new Edge(1, 2),
                new Edge(2, 1)
        )));
        graph.put(1, new ArrayList<>()); // no outgoing edges
        graph.put(2, new ArrayList<>()); // no outgoing edges
        graph.put(3, new ArrayList<>()); // no outgoing edges

        Stack<Integer> s = new Stack<>();
        int[] vis = new int[graph.size()];
        Arrays.fill(vis, -1);
        int[] dist = new int[vis.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == -1) {
                dfs(i, graph, vis, s);
            }
        }
        dist[0] = 0;
        while (!s.isEmpty()) {
            int k = s.pop();
            for (Edge e : graph.get(k)) {
                if ((dist[k] + e.w) < dist[e.i]) {
                    dist[e.i] = dist[k] + e.w;
                }
            }
        }


        System.out.println("Stack is " + s.toString());
        System.out.println("Dist : " + Arrays.toString(dist));
    }
}
