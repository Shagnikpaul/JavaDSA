package dsa.graphs;

import java.util.*;

class CustomComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        if (a[1] == b[1]) {
            return a[0] - b[0];
        } else {
            return a[1] - b[1];
        }
    }
}


public class DijkstraUsingPrior {

    public static void main(String[] args) {
        Map<Integer, ArrayList<Edge>> graph = new HashMap<>();

        // initialize adjacency lists
        for (int v = 0; v < 6; v++) {
            graph.put(v, new ArrayList<>());
        }

        // add undirected edges directly
        graph.get(0).add(new Edge(1, 4));
        graph.get(1).add(new Edge(0, 4));

        graph.get(0).add(new Edge(2, 4));
        graph.get(2).add(new Edge(0, 4));

        graph.get(1).add(new Edge(2, 2));
        graph.get(2).add(new Edge(1, 2));

        graph.get(2).add(new Edge(3, 3));
        graph.get(3).add(new Edge(2, 3));

        graph.get(2).add(new Edge(4, 1));
        graph.get(4).add(new Edge(2, 1));

        graph.get(2).add(new Edge(5, 6));
        graph.get(5).add(new Edge(2, 6));

        graph.get(3).add(new Edge(5, 2));
        graph.get(5).add(new Edge(3, 2));

        graph.get(4).add(new Edge(5, 3));
        graph.get(5).add(new Edge(4, 3));
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> p = new PriorityQueue<>(new CustomComparator()); // distance to reach that node, node
        p.add(new int[]{0, 0});

        while (!p.isEmpty()) {
            int[] node = p.remove();
            for (Edge i : graph.get(node[1])) {
                if ((node[0] + i.w) < dist[i.i]) {
                    dist[i.i] = node[0] + i.w;
                    p.add(new int[]{dist[i.i], i.i});
                }
            }
        }
        System.out.println("Distance array : " + Arrays.toString(dist));
    }
}
