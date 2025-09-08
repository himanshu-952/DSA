package Graphs;
    import java.util.*;
public class DijkstraAlgo {


class Solution {
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        boolean[] visited = new boolean[V];

        // min-heap based on distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{S, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (visited[u]) continue;
            visited[u] = true;

            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).get(0);
                int wt = adj.get(u).get(i).get(1);

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}

}
