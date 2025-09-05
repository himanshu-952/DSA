package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    class Solution {

    public void createGraph(List<List<Integer>> list, int course, int[][] pre) {
        for (int i = 0; i < course; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < pre.length; i++) {
            list.get(pre[i][1]).add(pre[i][0]);  // prereq -> course
        }
    }

    public boolean hasCycle(List<List<Integer>> list, int vertex, boolean[] visited, boolean[] recStack) {
        visited[vertex] = true;
        recStack[vertex] = true;

        for (int nei : list.get(vertex)) {
            if (recStack[nei]) return true; // back edge → cycle
            if (!visited[nei]) {
                if (hasCycle(list, nei, visited, recStack)) return true;
            }
        }

        recStack[vertex] = false; // backtrack
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        createGraph(list, numCourses, prerequisites);

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(list, i, visited, recStack)) {
                    return false; // cycle detected
                }
            }
        }
        return true; // no cycles
    }
}

}
