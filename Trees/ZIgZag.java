package BinaryTrees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZIgZag {
     public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int val) { this.val = val; }
        }
    class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                
                if (leftToRight) {
                    curr.add(node.val);
                } else {
                    curr.add(0, node.val); // insert at front for reverse order
                }

                
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            res.add(curr);
            leftToRight = !leftToRight; 
        }

        return res;
    }
}

}
