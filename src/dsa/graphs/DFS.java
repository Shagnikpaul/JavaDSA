package dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFS {


    public static void dfs(int startNode, int[] visited, HashMap<Integer, ArrayList<Integer>> adjList, ArrayList<Integer> traversal) {
        visited[startNode] = 1;
        traversal.add(startNode);

        for (int i : adjList.get(startNode)) {
            if (visited[i] == 0)
                dfs(i, visited, adjList, traversal);
        }

    }

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        adjList.put(0, new ArrayList<>(Arrays.asList(1, 2)));
        adjList.put(1, new ArrayList<>(Arrays.asList(0, 3, 4)));
        adjList.put(2, new ArrayList<>(Arrays.asList(0, 4)));
        adjList.put(3, new ArrayList<>(Arrays.asList(1, 5)));
        adjList.put(4, new ArrayList<>(Arrays.asList(1, 2, 5)));
        adjList.put(5, new ArrayList<>(Arrays.asList(3, 4)));


        int[] visited = new int[adjList.size()];
        Arrays.fill(visited, 0);

        ArrayList<Integer> traversal = new ArrayList<>();

        dfs(0, visited, adjList, traversal);
        System.out.println("DFS Traversal result : " + traversal);
    }
}
