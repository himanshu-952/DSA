package Graphs;
import java.util.*;
public class TopologicalSort {
    public List<Integer> topSort(List<List<Integer>> graph){
        List<Integer> res= new ArrayList<>();
        Stack<Integer> stack= new Stack<>();
        boolean[] visited= new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if(!visited[i]){
                helper(graph, i, stack, visited);
            }
        }
       while(!stack.isEmpty()){
          res.add(stack.pop());
       }
       return res;
    }
    public void helper(List<List<Integer>> list, int vertex , Stack<Integer> stack ,boolean[] visited ){
        visited[vertex]=true;
        for (int neibhour:list.get(vertex)) {
            if(!visited[neibhour]){
                helper(list, neibhour, stack, visited);
            }
        }
        stack.add(vertex);
    }
}
