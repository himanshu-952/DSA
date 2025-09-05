package Graphs;

public class BipartiteGraph {
    class Solution {
    public boolean isBipartite(int[][] graph) {
        int[]color=new int[graph.length];
        boolean[]visited= new boolean[graph.length];
        for(int i=0 ; i<graph.length;i++){
            if(!visited[i]){
                color(graph , i , 0 , color , visited);
            }
        }
        for(int i=0 ; i<graph.length; i++){
            for(int j=0 ; j<graph[i].length; j++){
                if(color[i]==color[graph[i][j]]){
                    return false;
                }
            }
        }
        return true;
    }
    public void color(int[][] graph , int v , int col , int[]color, boolean[]visited){
        visited[v]=true;
        color[v]=col;
        for(int i=0 ; i<graph[v].length; i++){
            int neibhour=graph[v][i];
            if(!visited[neibhour]){
                color(graph , neibhour, 1-col , color , visited);
            }
        }
    }
}

}
