package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
   class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Put all initially rotten oranges in queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c, 0}); // {row, col, time}
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges → already done
        if (fresh == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], time = cur[2];
            minutes = Math.max(minutes, time);

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2; // make rotten
                    fresh--;
                    q.offer(new int[]{nr, nc, time + 1});
                }
            }
        }

        // If some fresh oranges are left → impossible
        return fresh == 0 ? minutes : -1;
    }
}

}
