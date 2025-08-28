package BinarySearchTrees;
import java.util.*;
public class TwoSumFour {
         public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val ;}
  }
   class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> seen = new HashSet<>();
        return helper(root, k, seen);
    }

    private boolean helper(TreeNode root, int k, HashSet<Integer> seen) {
        if (root == null) return false;

        if (seen.contains(k - root.val)) {
            return true;
        }
        seen.add(root.val);

        
        return helper(root.left, k, seen) || helper(root.right, k, seen);
    }
}

}
