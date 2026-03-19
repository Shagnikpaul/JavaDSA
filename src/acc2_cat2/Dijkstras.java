package acc2_cat2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstras {


    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 3, 0},
                {0, 0, 1, 2},
                {0, 4, 0, 8},
                {0, 0, 0, 0}
        };

        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != 0) {
                    adj.get(i).add(j);
                }
            }
        }
        System.out.println("Adj Matrix : ");
        for (int i = 0; i < graph.length; i++) {
            System.out.println("Node " + i + ": " + adj.get(i).toString());
        }
        // node to reach, distance to reach it
        PriorityQueue<int[]> p = new PriorityQueue<>((int[] a, int[] b) -> {
            return a[1] - b[1];
        });

        p.add(new int[]{0, 0});
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!p.isEmpty()) {
            int[] ed = p.remove();
            for (Integer x : adj.get(ed[0])) {
                if ((ed[1] + graph[ed[0]][x]) < dist[x]) {
                    dist[x] = ed[1] + graph[ed[0]][x];
                    p.add(new int[]{x, dist[x]});
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
