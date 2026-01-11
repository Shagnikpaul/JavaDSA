package dsa.graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

class NewNode {
    int row;
    int col;
    int dist;

    public NewNode(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}


class CustomMaZCom implements Comparator<NewNode> {
    @Override
    public int compare(NewNode o1, NewNode o2) {
        return o1.dist - o2.dist;
    }
}

public class BinaryMaze {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };


        PriorityQueue<NewNode> p = new PriorityQueue<>(new CustomMaZCom());
        int[][] dist = new int[grid.length][grid[0].length];

        p.add(new NewNode(0, 0, 0));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dist[i][j] = Integer.MAX_VALUE;
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        dist[0][0] = 0;

        while (!p.isEmpty()) {
            NewNode s = p.remove();

            int[] r = {-1, 1, 0, 0, 1, 1, -1, -1};
            int[] c = {0, 0, -1, 1, 1, -1, -1, 1};
            int row = s.row;
            int col = s.col;
            for (int i = 0; i < r.length; i++) {
                int rr = row + r[i];
                int cc = col + c[i];
                if ((rr >= 0 && rr < dist.length) && (cc >= 0 && cc < dist[0].length)) {
                    if (grid[rr][cc] != 1) {
                        if (dist[row][col] + 1 < dist[rr][cc]) {
                            dist[rr][cc] = dist[row][col] + 1;
                            p.add(new NewNode(rr, cc, dist[rr][cc]));
                        }
                    }
                }
            }
        }
        System.out.println("Distance to reach des " + (dist[dist.length - 1][dist[0].length - 1] + 1));
    }
}
