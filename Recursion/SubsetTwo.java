package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetTwo {
    class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort first for duplicate handling
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> current, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // INCLUDE
        current.add(nums[index]);
        helper(nums, result, current, index + 1);
        current.remove(current.size() - 1); // backtrack

        // EXCLUDE → skip duplicates
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }
        helper(nums, result, current, nextIndex);
    }
}

}
