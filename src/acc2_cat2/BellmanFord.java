package acc2_cat2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BellmanFord {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 2, 0},
                {0, 0, 3, 2},
                {0, 1, 0, 5},
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
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < graph.length - 1; i++) {
            for (int n : adj.keySet()) { // basically all the nodes... 0 to n-1 inclusive
                for (int edge : adj.get(n)) {
                    if (dist[n] != Integer.MAX_VALUE && (dist[n] + graph[n][edge] < dist[edge])) {
                        dist[edge] = dist[n] + graph[n][edge];
                    }
                }
            }
        }

        System.out.println("After bellman : " + Arrays.toString(dist));
    }
}
