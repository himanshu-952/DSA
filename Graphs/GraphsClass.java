import java.util.*;
public class GraphsClass {
    static class edge{
     int source;
     int dest;
     int weight;

     public edge(int s , int d , int w){
        this.source=s;
        this.dest=d;
        this.weight=w;
     }

    }

    public static void bfs(ArrayList<edge>[]graph ){
        boolean visited[]= new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                bfsutil(graph, visited);
            }
        }
    }

    public static void bfsutil(ArrayList<edge>[] graph , boolean visited[]){
        Queue<Integer> q= new LinkedList<>();
       

        q.add(0);
         while (!q.isEmpty()) {
            int curr= q.remove();
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr]=true;
                for(int i=0 ; i<graph[curr].size(); i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
         }

    }

    public static void dfs(ArrayList<edge>[] graph ){
        boolean visited[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                dfsutil(graph, i, visited);
            }
        }
    }

    public static void dfsutil(ArrayList<edge>[] graph , int i , boolean visited[]){
       

       
         visited[i]=true;
         System.out.print(i+" ");
       
        for (int j = 0; j < graph[i].size(); j++) {
            if(!visited[graph[i].get(j).dest]){
                dfsutil(graph, graph[i].get(j).dest , visited);
            }
        }
        
    }

    public static boolean hasPath(ArrayList<edge>[] graph , int src  , int dest , boolean visited[]){

    if(src==dest){
        return true;
    }

    visited[src]=true;

    for (int i = 0; i < graph[src].size(); i++) {
        if(!visited[graph[src].get(i).dest] && hasPath(graph, graph[src].get(i).dest, dest, visited)){
            return true;
        }
    }

    return false;

    }

   

    public static boolean detectCycle(ArrayList<edge>graph[]){

        boolean visited[]=new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
          if(!visited[i]){
            if(detectCycleUtil(graph, i,-1, visited)){
                return true;
            }
            
          }
        }

        return false;

    }

    
public static boolean detectCycleUtil(ArrayList<edge> graph[], int curr, int parent, boolean visited[]) {
    visited[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
        int neighbor = graph[curr].get(i).dest;

        if (!visited[neighbor]) {
            if (detectCycleUtil(graph, neighbor, curr, visited)) {
                return true;
            }
        } else if (neighbor != parent) {
            // If the neighbor is visited and is not the parent of current node
            return true;
        }
    }

    return false;
}

public static boolean biparite(ArrayList<edge> graph[] ){
    boolean visited[]= new boolean[graph.length];
     int col[]=new int[graph.length];
    for (int i = 0; i < col.length; i++) {
        col[i]=-1;

      }
    for (int i = 0; i < graph.length; i++) {
        if(!visited[i] && !bipariteUtil(graph, i , visited, col)){
            return false;
        }
    }
    return true;
}

private static boolean bipariteUtil(ArrayList<edge> graph[] , int parent , boolean visited[] , int col[]){
 
      Queue<Integer> q= new LinkedList<>();
     
      

      q.add(parent);
      visited[parent]=true;
      col[parent]=0;

      while(!q.isEmpty()){
       parent= q.remove();
         for (int i = 0; i < graph[parent].size(); i++) {
            if(col[graph[parent].get(i).dest]==-1){
                q.add(graph[parent].get(i).dest);
                if(col[parent]==0){
                    col[graph[parent].get(i).dest]=1;
                }
                else{
                    col[graph[parent].get(i).dest]=0;
                }
            }

            else if(col[graph[parent].get(i).dest]==col[parent]){
                return false;
            }
         }
      }

      return true;
    
}

public static boolean cycleDetect2(ArrayList<edge> graph[]){
    boolean visited[]= new boolean[graph.length];
    boolean stack[]= new boolean[graph.length];

    for (int i = 0; i < graph.length; i++) {
        if(!visited[i]){
            if(cycleDetect2Util(graph, i, visited, stack)){
            return true;
        }
        }
    }
    return false;
}

public static boolean cycleDetect2Util(ArrayList<edge> graph[],int parent , boolean visited[] , boolean stack[]){

    visited[parent]=true;
    stack[parent]=true;

    for (int i = 0; i < graph[parent].size(); i++) {
        int neighbor= graph[parent].get(i).dest;

        if(stack[neighbor]){
           
            return true;
        }
        else if(!visited[neighbor]){
            if(cycleDetect2Util(graph, neighbor, visited, stack)){
               
                return true;
            }
        }
    }
   stack[parent]=false;
    return false;

}

public static void topologicalSort(ArrayList<edge> graph[]) {
    boolean visited[] = new boolean[graph.length];
    Stack<Integer> s = new Stack<>();

    // Fix: Run DFS for all unvisited nodes
    for (int i = 0; i < graph.length; i++) {
        if (!visited[i]) {
            topologicalSortUtil(graph, i, visited, s);
        }
    }

    // Print topological order
    while (!s.isEmpty()) {
        System.out.print(s.pop() + " ");
    }
}

public static void topologicalSortUtil(ArrayList<edge> graph[], int node, boolean visited[], Stack<Integer> s) {
    visited[node] = true;

    for (int i = 0; i < graph[node].size(); i++) {
        int neighbor = graph[node].get(i).dest;
        if (!visited[neighbor]) {
            topologicalSortUtil(graph, neighbor, visited, s);
        }
    }

    // After visiting neighbors, add to stack
    s.push(node);
}

public static void topSortByBFS(ArrayList<edge> graph[]){

    int indegree[]= new int[graph.length];
    Queue<Integer> q= new LinkedList<>();
   

    for (int i = 0; i < graph.length; i++) {
        for (int j = 0; j < graph[i].size(); j++) {
            int dest= graph[i].get(j).dest;
            indegree[dest]++;
            
        }
    }

    for (int i = 0; i < indegree.length; i++) {
        if(indegree[i]==0){
            q.add(i);
        }}

          while(!q.isEmpty()){
     int parent= q.remove();
     System.out.print(parent+" ");
     for (int i = 0; i < graph[parent].size(); i++) {
        int neighbor=graph[parent].get(i).dest;
        indegree[neighbor]=indegree[neighbor]-1;
        if(indegree[neighbor]==0){
            q.add(neighbor);
        }
     }

     }

    }

    public static void printAllPaths(ArrayList<edge>[] graph, int src, int dest, boolean[] visited, String path) {
    if (src == dest) {
        System.out.println(path + dest);
        return;
    }

    visited[src] = true;

    for (int i = 0; i < graph[src].size(); i++) {
        int neighbor = graph[src].get(i).dest;
        if (!visited[neighbor]) {
            printAllPaths(graph, neighbor, dest, visited, path + src + "->");
        }
    }

    visited[src] = false; // backtrack
}

static class pair implements Comparable<pair>{

    int vertex;
    int dist;

    public pair(int n , int d){
          this.vertex=n;
          this.dist=d;
    }

    @Override
    public  int  compareTo(pair p2){
        return this.dist-p2.dist;
    }


}

public static void dijkstra(ArrayList<edge> graph[] , int src){

    int dist[]= new int[graph.length];
    boolean visited[]= new boolean[graph.length];
    for (int i = 0; i < dist.length; i++) {
        if(i==src){
            dist[src]=0;

        }

        else{
           dist[i]=Integer.MAX_VALUE;
        }
        
    }

    PriorityQueue<pair> pq= new PriorityQueue<>();
   pq.add(new pair(src, 0));

   while (!pq.isEmpty()) {
    int parent=pq.remove().vertex;
   
    if(!visited[parent]){
        visited[parent]=true;
        for (int i = 0; i < graph[parent].size(); i++) {
        
        int neighbor=graph[parent].get(i).dest;
        
        int u=dist[parent];
        int v=dist[neighbor];
        int wt=graph[parent].get(i).weight;

        if(u+wt<v){
            dist[neighbor]=u+wt;
             pq.add(new pair(neighbor, dist[neighbor]));
        }
       

    }

    }


   }

for (int i = 0; i < dist.length; i++) {
    System.out.print(dist[i]+" ");
}

}


    public static void bellmanFord(int vertices, ArrayList<edge> edges, int src) {
        int[] dist = new int[vertices];
        
        // Step 1: Initialize distances
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 2: Relax all edges V - 1 times
        for (int i = 1; i <= vertices - 1; i++) {
            for (edge e : edges) {
                if (dist[e.source] != Integer.MAX_VALUE && dist[e.source] + e.weight < dist[e.dest]) {
                    dist[e.dest] = dist[e.source] + e.weight;
                }
            }
        }

        // Step 3: Check for negative-weight cycles
        for (edge e : edges) {
            if (dist[e.source] != Integer.MAX_VALUE && dist[e.source] + e.weight < dist[e.dest]) {
                System.out.println("Graph contains a negative weight cycle!");
                return;
            }
        }


        // Step 4: Print shortest distances
        System.out.println("Vertex\tDistance from Source " + src);
        for (int i = 0; i < vertices; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println(i + "\t" + "INF");
            else
                System.out.println(i + "\t" + dist[i]);
        }
    }

    static class pairForMST implements Comparable<pairForMST>{
        int vertex;
        int cost;

        public pairForMST(int v , int c){
            this.vertex=v;
            this.cost=c;
        }

        @Override
        public int compareTo(pairForMST p2){
            return this.cost-p2.cost;
        }
    }

    public static void prims(ArrayList<edge> graph[]){

        boolean visited[]= new boolean[graph.length];
       int cost= 0;
        PriorityQueue<pairForMST> pq= new PriorityQueue<>();
        pq.add(new pairForMST(0, 0));

        while (!pq.isEmpty()) {
            pairForMST curr= pq.remove();
            if(!visited[curr.vertex]){
                visited[curr.vertex]=true;
               cost+=curr.cost;
                for (int i = 0; i < graph[curr.vertex].size(); i++) {
                    edge e= graph[curr.vertex].get(i);
                    pq.add(new pairForMST(e.dest, e.weight));

                }
            }
        }

        System.out.println(cost);
        

    }




    public static void main(String[] args) {
        int v=5;
        ArrayList<edge>[] graph= new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new edge(0, 1, 3));
        graph[1].add(new edge(1, 0, 2));
        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 3, 2));
        graph[2].add(new edge(2, 1, 3));
        graph[2].add(new edge(2, 3, 1));
        graph[2].add(new edge(2, 4, 2));
        graph[3].add(new edge(3, 2, 1));
        graph[3].add(new edge(3, 1, 2));

       dfs(graph);
      
      
        

    }
}
