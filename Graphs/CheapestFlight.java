import java.util.*;

public class CheapestFlight {

    static class edge {
        int source;
        int dest;
        int weight;

        public edge(int s, int d, int w) {
            this.source = s;
            this.dest = d;
            this.weight = w;
        }
    }

    static class infoOfFlight {
        int vertex;
        int cost;
        int stop;

        public infoOfFlight(int v, int c, int s) {
            this.vertex = v;
            this.cost = c;
            this.stop = s;
        }
    }

    public static int findway(int flight[][], ArrayList<edge> graph[], int s, int d, int k) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flight.length; i++) {
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];

            graph[src].add(new edge(src, dest, wt));
        }

        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        Queue<infoOfFlight> q = new LinkedList<>();
        q.add(new infoOfFlight(s, 0, 0));

        int cheapestPrice = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            infoOfFlight parent = q.remove();

            if (parent.stop > k) {
                continue;
            }

            for (int i = 0; i < graph[parent.vertex].size(); i++) {
                edge neighbor = graph[parent.vertex].get(i);

                int u = parent.cost;
                int wt = neighbor.weight;
                int totalCost = u + wt;

                if (totalCost < dist[neighbor.dest]) {
                    dist[neighbor.dest] = totalCost;
                    q.add(new infoOfFlight(neighbor.dest, totalCost, parent.stop + 1));
                } else if (parent.stop < k) {
                    q.add(new infoOfFlight(neighbor.dest, totalCost, parent.stop + 1));
                }
            }
        }

        cheapestPrice = dist[d];

        if (cheapestPrice == Integer.MAX_VALUE) {
            System.out.println(-1);
            return -1;
        } else {
            System.out.println(cheapestPrice);
            return cheapestPrice;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = { {0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200} };
        ArrayList<edge> graph[] = new ArrayList[n];

        findway(flights, graph, 0, 3, 1); // expected: 700
    }
}
