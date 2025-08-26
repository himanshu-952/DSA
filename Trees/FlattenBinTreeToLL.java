package BinaryTrees;
import java.util.*;
public class FlattenBinTreeToLL {

    Queue<TreeNode> q ;
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        // Flatten left and right
        flatten(root.left);
        flatten(root.right);
        
        // Store left and right subtrees
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        // Move left to right
        root.left = null;
        root.right = left;
        
        // Move to end of new right and attach original right
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;
    }
}

}
