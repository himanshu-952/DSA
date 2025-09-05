package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnAlgo {
    public List<Integer> topSort(List<List<Integer>> graph){
        int[] indegree= new int[graph.size()];
        List<Integer> res= new ArrayList<>();
        for (int i=0 ; i<graph.size(); i++) {
            for (int j : graph.get(i)) {
                indegree[j]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0)q.offer(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for (int neibhour:graph.get(curr)) {
                --indegree[neibhour];
                if(indegree[neibhour]==0)q.offer(neibhour);
            }
        }
        //cycle detection
        if(res.size()!=graph.size()){
            return new ArrayList<>();
        }
        else{
               return res;
        }
        
    }
}
