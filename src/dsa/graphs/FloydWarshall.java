package dsa.graphs;

public class FloydWarshall {
    public static void main(String[] args) {

        // adjacency matrix
        int[][] matrix = {
                {0, 25},
                {-1, 0}
        };

        int n = matrix.length;
        for (int k = 0; k < n; k++) {           // intermediate vertex
            for (int i = 0; i < n; i++) {       // source vertex
                for (int j = 0; j < n; j++) {   // destination vertex
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        System.out.println("RESULT ");
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[0].length; k++) {
                System.out.print(matrix[j][k] + " ");
            }
            System.out.println("");
        }

    }
}
