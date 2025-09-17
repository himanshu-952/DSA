package Graphs;

public class FloydWarshal {
    class Solution {
    public int[][] shortestDistance(int[][] matrix) {
        int n = matrix.length;
        int[][] dist = new int[n][n];

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = matrix[i][j];
            }
            dist[i][i] = 0;
        }

        
        for (int k = 0; k < n; k++) {   // via node
            for (int i = 0; i < n; i++) {   // source
                for (int j = 0; j < n; j++) {   // dest
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        return dist;
    }
}

}
