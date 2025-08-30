package dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class SurroundedRegions {

    static int borderFound;

    public static void dfs(int startR, int startC, char[][] graph, int[][] vis, ArrayList<int[]> l) {
        l.add(new int[]{startR, startC});

        vis[startR][startC] = 1;
        if (startR == 0 || startR == vis.length - 1 || startC == 0 || startC == vis[0].length - 1) {
            borderFound = 1;
        }

        if (startR - 1 >= 0 && vis[startR - 1][startC] != 1 && graph[startR - 1][startC] == 'O')
            dfs(startR - 1, startC, graph, vis, l);
        if (startR + 1 < vis.length && vis[startR + 1][startC] != 1 && graph[startR + 1][startC] == 'O')
            dfs(startR + 1, startC, graph, vis, l);
        if (startC - 1 >= 0 && vis[startR][startC - 1] != 1 && graph[startR][startC - 1] == 'O')
            dfs(startR, startC - 1, graph, vis, l);
        if (startC + 1 <= vis[0].length - 1 && vis[startR][startC + 1] != 1 && graph[startR][startC + 1] == 'O')
            dfs(startR, startC + 1, graph, vis, l);

    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'O'},
                {'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'X', 'O', 'X', 'X', 'O', 'O', 'X', 'X', 'X'},
                {'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O'},
                {'X', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'X', 'O'}
        };


        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    visited[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != 1) {
                    System.out.println("Running at " + i + ", " + j);
                    ArrayList<int[]> l = new ArrayList<>();
                    borderFound = 0;
                    dfs(i, j, board, visited, l);
                    System.out.println("Got a list " + l.toString());
                    if (borderFound == 0) {
                        for (int[] k : l) {
                            board[k[0]][k[1]] = 'X';
                        }
                    }
                }
            }
        }

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
