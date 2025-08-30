package dsa.graphs;

import java.util.ArrayList;

public class NumberOfEnclaves {

    static int borderFound;

    public static void dfs(int startR, int startC, int[][] vis, ArrayList<int[]> l) {
        l.add(new int[]{startR, startC});
        vis[startR][startC] = 1;
        if (startR == 0 || startR == vis.length - 1 || startC == 0 || startC == vis[0].length - 1) {
            borderFound = 1;
        }

        if (startR - 1 >= 0 && vis[startR - 1][startC] != 1)
            dfs(startR - 1, startC, vis, l);
        if (startR + 1 < vis.length && vis[startR + 1][startC] != 1)
            dfs(startR + 1, startC, vis, l);
        if (startC - 1 >= 0 && vis[startR][startC - 1] != 1)
            dfs(startR, startC - 1, vis, l);
        if (startC + 1 <= vis[0].length - 1 && vis[startR][startC + 1] != 1)
            dfs(startR, startC + 1, vis, l);

    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = 1;
                }
            }
        }
        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != 1) {
                    //System.out.println("Running at " + i + ", " + j);
                    ArrayList<int[]> l = new ArrayList<>();
                    borderFound = 0;
                    dfs(i, j, visited, l);
                    //System.out.println("Got a list " + l.toString());
                    if (borderFound == 0) {
                        s += l.size();
                    }
                }
            }
        }
        //System.out.println("Total Enclaves  : " + s);
    }
}
