package BinaryTrees;

import java.util.*;


public class RightView {
    
 
  public class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { data = val; left = null; right = null; }
  }
 
    class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null); // level marker

        TreeNode prev = null;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                
                if (prev != null) res.add(prev.data);

                
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
              
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                prev = node; 
            }
        }
        return res;
    }
}

}
