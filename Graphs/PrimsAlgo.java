package Graphs;

import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
    class Solution {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[V];
        
        
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int wt = curr[1];

            if (visited[u]) continue;
            visited[u] = true;
            cost += wt;

            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).get(0);
                int w = adj.get(u).get(i).get(1);

                if (!visited[v]) {
                    pq.add(new int[]{v, w});
                }
            }
        }
        return cost;
    }
}

}
