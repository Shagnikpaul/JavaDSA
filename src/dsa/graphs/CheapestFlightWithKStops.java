package dsa.graphs;


import java.util.*;

public class CheapestFlightWithKStops {
    public static void main(String[] args) {
        int n = 5;

        int[][] flights = {
                {0, 1, 5},
                {1, 2, 5},
                {0, 3, 2},
                {3, 1, 2},
                {1, 4, 1},
                {4, 2, 1}
        };

        int src = 0;
        int dst = 2;
        int k = 2;

        HashMap<Integer, ArrayList<Edge>> h = new HashMap<>();

        for (int i = 0; i < n; i++) {
            h.put(i, new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            h.get(flights[i][0]).add(new Edge(flights[i][1], flights[i][2]));
        }
        // node,dist,stops
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        p.add(new int[]{src, dist[src], 0});


        while (!p.isEmpty()) {
            int[] o = p.remove();
            System.out.println("In node " + o[0] + " dist = " + o[1] + " stops till now " + o[2] + "which has dis = " + dist[o[0]]);
//            if (o[0] == dst) {
//                System.out.println("Shortest distance : " + o[1]);
//                break;
//            }
            if (o[2] > k) {
                System.out.println("elimin " + o[0]);
                dist[o[0]] = Integer.MAX_VALUE;
                continue;
            }
            if (dist[o[0]] == Integer.MAX_VALUE) {
                dist[o[0]] = o[1];
            }
            for (Edge e : h.get(o[0])) {
                System.out.println(e.i + " Dest dist = " + dist[e.i] + "which is fea ? " + ((o[1] + e.w) < dist[e.i]) + " since current dis = " + dist[e.i] + " por = " + (o[1] + e.w));
                if ((o[1] + e.w) < dist[e.i]) {

                    dist[e.i] = o[1] + e.w;

                    System.out.println(e.i + " Dest dist = " + dist[e.i]);
                    p.add(new int[]{e.i, dist[e.i], o[2] + 1});
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE) {
            System.out.println("no path found ....");
        } else {
            System.out.println("dis .... " + dist[dst]);
        }
    }
}
