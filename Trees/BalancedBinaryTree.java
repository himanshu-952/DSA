package BinaryTrees;

public class BalancedBinaryTree {
   class Solution {
     public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int val) { this.val = val; }
        }
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int lh = height(node.left);
        if (lh == -1) return -1; // left subtree not balanced

        int rh = height(node.right);
        if (rh == -1) return -1; // right subtree not balanced

        if (Math.abs(lh - rh) > 1) return -1; // current node not balanced

        return 1 + Math.max(lh, rh);
    }
}

}
