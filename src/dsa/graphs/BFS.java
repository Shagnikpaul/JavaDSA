package dsa.graphs;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        adjList.put(0, new ArrayList<>(Arrays.asList(1, 2)));
        adjList.put(1, new ArrayList<>(Arrays.asList(0, 3, 4)));
        adjList.put(2, new ArrayList<>(Arrays.asList(0, 4)));
        adjList.put(3, new ArrayList<>(Arrays.asList(1, 5)));
        adjList.put(4, new ArrayList<>(Arrays.asList(1, 2, 5)));
        adjList.put(5, new ArrayList<>(Arrays.asList(3, 4)));

        //System.out.println(adjList);

        int[] visited = new int[adjList.size()];
        Arrays.fill(visited, 0);
        visited[0] = 1; // say the 0th node is the starting node

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        ArrayList<Integer> traversal = new ArrayList<>();
        while (!q.isEmpty()){
            int checkNode = q.poll();
            traversal.add(checkNode);
            for(int i: adjList.get(checkNode)) {
                if(visited[i] == 0){
                    visited[i] = 1;
                    q.add(i);
                }
            }
        }

        System.out.println("Traversal result : "+traversal);

    }
}
