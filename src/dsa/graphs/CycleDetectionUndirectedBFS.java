package dsa.graphs;

import java.util.*;


public class CycleDetectionUndirectedBFS {
    public static void main(String[] args) {


        // graph with cycle
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        graph.put(1, new ArrayList<>(Arrays.asList(2, 3)));
        graph.put(2, new ArrayList<>(Arrays.asList(1, 5)));
        graph.put(3, new ArrayList<>(Arrays.asList(1, 4, 6)));
        graph.put(4, new ArrayList<>(List.of(3)));
        graph.put(5, new ArrayList<>(Arrays.asList(2, 7)));
        graph.put(6, new ArrayList<>(Arrays.asList(3, 7)));
        graph.put(7, new ArrayList<>(Arrays.asList(5, 6)));

        // graph without loop
//        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
//
//        graph.put(1, new ArrayList<>(Arrays.asList(2, 3)));
//        graph.put(2, new ArrayList<>(Arrays.asList(1, 5)));
//        graph.put(3, new ArrayList<>(Arrays.asList(1, 4, 6)));
//        graph.put(4, new ArrayList<>(Arrays.asList(3)));
//        graph.put(5, new ArrayList<>(Arrays.asList(2, 7)));
//        graph.put(6, new ArrayList<>(Arrays.asList(3)));
//        graph.put(7, new ArrayList<>(Arrays.asList(5)));


        int[] visited = new int[graph.size() + 1];

        Node n = new Node(1, -1);
        visited[1] = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(n);
        boolean loopFound = false;
        while (!q.isEmpty()) {
            Node t = q.remove();
            for (int i : graph.get(t.value)) {
                if (!(i == t.parent)) {
                    if (!(visited[i] == 1)) {
                        visited[i] = 1;
                        Node ch = new Node(i, t.value);
                        q.offer(ch);
                    } else {
                        System.out.println("Loop Found ");
                        loopFound = true;
                        return;
                    }
                }
            }
        }
        System.out.println("Loop not found");
    }
}
