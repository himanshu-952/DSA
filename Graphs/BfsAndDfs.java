package Graphs;
   import java.util.*;
public class BfsAndDfs {
 

class Solution {
    // DFS
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsHelper(list, visited, i, adj);
            }
        }
        return list;
    }

    public void dfsHelper(List<Integer> list, boolean[] visited, int node, List<List<Integer>> adj) {
        visited[node] = true;
        list.add(node);
        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfsHelper(list, visited, neigh, adj);
            }
        }
    }

    // BFS
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfsHelper(i, adj, visited, res);
            }
        }
        return res;
    }

    public void bfsHelper(int start, List<List<Integer>> adj, boolean[] visited, List<Integer> res) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.offer(neigh);
                }
            }
        }
    }
}

}
