package BinaryTrees;

public class LowestCommonAncestor {
   


    class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int val) { this.val = val; }
        }
        
    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return lca;
    }

    public int helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;

        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);

        int mid = (root == p || root == q) ? 1 : 0;

        // If any two of the three flags (mid, left, right) are 1, this is LCA
        if (mid + left + right >= 2) {
            lca = root;
        }

        return (mid + left + right > 0) ? 1 : 0;
    }
}

}


