package contest1;

import java.util.HashMap;

public class islandsSum {

    public static void markNeighbors(int grid[][], int isVisited[][], int n, int m, HashMap<Integer, Integer> mp, int i,
            int j) {
        // left
        if ((i - 1) >= 0 && isVisited[i - 1][j] == -1 && grid[i - 1][j] != 0) {
            mp.put(isVisited[i][j], mp.get(isVisited[i][j]) + grid[i - 1][j]);
            isVisited[i - 1][j] = isVisited[i][j];
            markNeighbors(grid, isVisited, n, m, mp, i - 1, j);
        }

        // rigth
        if ((i + 1) < n && isVisited[i + 1][j] == -1 && grid[i + 1][j] != 0) {
            mp.put(isVisited[i][j], mp.get(isVisited[i][j]) + grid[i + 1][j]);
            isVisited[i + 1][j] = isVisited[i][j];
            markNeighbors(grid, isVisited, n, m, mp, i + 1, j);
        }
        // bot
        if ((j + 1) < m && isVisited[i][j + 1] == -1 && grid[i][j + 1] != 0) {
            mp.put(isVisited[i][j], mp.get(isVisited[i][j]) + grid[i][j + 1]);
            isVisited[i][j + 1] = isVisited[i][j];
            markNeighbors(grid, isVisited, n, m, mp, i, j + 1);
        }

        // tpo
        if ((j - 1) >= 0 && isVisited[i][j - 1] == -1 && grid[i][j - 1] != 0) {
            mp.put(isVisited[i][j], mp.get(isVisited[i][j]) + grid[i][j - 1]);
            isVisited[i][j - 1] = isVisited[i][j];
            markNeighbors(grid, isVisited, n, m, mp, i, j - 1);
        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 0, 0, 1 }, { 11, 0, 6 }, { 0, 10, 2 }, { 0, 0, 0 }, { 8, 0, 0 } };

        int n = grid.length;
        int m = grid[0].length;
        int k = 19;

        int[][] isVisited = new int[n][m];
        int[][] ids = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isVisited[i][j] = -1;

            }
        }
        int id = 1;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 0)
                    continue;

                if (isVisited[i][j] != -1) {
                    System.out.println("skeiiped");
                    continue;
                } else {
                    // right
                    if ((i + 1) < n && (isVisited[i + 1][j] != -1)) {
                        mp.put(isVisited[i + 1][j], mp.get(isVisited[i + 1][j]) + grid[i][j]);
                        isVisited[i][j] = isVisited[i + 1][j];

                    }

                    // left
                    else if ((i - 1) >= 0 && (isVisited[i - 1][j] != -1)) {
                        mp.put(isVisited[i - 1][j], mp.get(isVisited[i - 1][j]) + grid[i][j]);
                        isVisited[i][j] = isVisited[i - 1][j];

                        markNeighbors(grid, isVisited, n, m, mp, i, j);

                    }

                    // top
                    else if ((j - 1) >= 0 && (isVisited[i][j - 1] != -1)) {

                        mp.put(isVisited[i][j - 1], mp.get(isVisited[i][j - 1]) + grid[i][j]);
                        isVisited[i][j] = isVisited[i][j - 1];

                        markNeighbors(grid, isVisited, n, m, mp, i, j);

                    }

                    // bottom
                    else if ((j + 1) < m && isVisited[i][j + 1] != -1) {

                        // System.out.println("Id is " + isVisited[i][j + 1]);
                        mp.put(isVisited[i][j + 1], mp.get(isVisited[i][j + 1]) + grid[i][j]);
                        isVisited[i][j] = isVisited[i][j + 1];

                        markNeighbors(grid, isVisited, n, m, mp, i, j);
                    }

                    else {
                        /// System.out.println("ran new id " + id);
                        mp.put(id, grid[i][j]);
                        isVisited[i][j] = id++;

                        markNeighbors(grid, isVisited, n, m, mp, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(isVisited[i][j] + ", ");
            }
            System.out.println();
        }
        int c = 0;
        for (Integer val : mp.values()) {
            // System.out.println("Val = " + val);
            if (val % k == 0)
                c++;
        }

        // System.out.println("Cont = " + c);

    }
}
