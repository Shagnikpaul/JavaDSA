package dsa.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {


    public static void distanceUsingBFS(int[][] mat, int[][] visited, int[][] dis, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] t = q.remove();
            int r = t[0];
            int c = t[1];
            int l = t[2];

            // left
            if ((r - 1) >= 0 && visited[r - 1][c] != 1) {
                visited[r - 1][c] = 1;
                dis[r - 1][c] = l + 1;
                q.offer(new int[]{r - 1, c, l + 1});
            }

            // right
            if ((r + 1) < mat.length && visited[r + 1][c] != 1) {
                visited[r + 1][c] = 1;
                dis[r + 1][c] = l + 1;
                q.offer(new int[]{r + 1, c, l + 1});
            }

            // up
            if ((c - 1) >= 0 && visited[r][c - 1] != 1) {
                visited[r][c - 1] = 1;
                dis[r][c - 1] = l + 1;
                q.offer(new int[]{r, c - 1, l + 1});
            }

            // up
            if ((c + 1) < mat[0].length && visited[r][c + 1] != 1) {
                visited[r][c + 1] = 1;
                dis[r][c + 1] = l + 1;
                q.offer(new int[]{r, c + 1, l + 1});
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] distances = new int[mat.length][mat[0].length];
        int[][] visited = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    distances[i][j] = 0;
                    visited[i][j] = 1;
                    q.offer(new int[]{i, j, 0});
                } else {
                    visited[i][j] = 0;
                }
            }
        }


        distanceUsingBFS(mat, visited, distances, q);

        for (int[] t : distances) {
            System.out.println(Arrays.toString(t));
        }

    }
}
