package Recursion;

import java.util.ArrayList;
import java.util.List;
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);       // choose
            backtrack(candidates, target - candidates[i], i, current, result); // i not i+1 because we can reuse
            current.remove(current.size() - 1); // backtrack
        }
    }
}
