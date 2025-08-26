package BinaryTrees;
import java.util.*;

public class MAxWidth {
    class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int val) { this.val = val; }
        }

        public class Pair {
            TreeNode node;
            int dist;
            public Pair(TreeNode node, int dist) {
                this.node = node;
                this.dist = dist;
            }
        }

        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root, 0));
            int maxWidth = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                int minIndex = q.peek().dist;  // leftmost index in this level
                int first = 0, last = 0;

                for (int i = 0; i < size; i++) {
                    Pair p = q.poll();
                    TreeNode node = p.node;
                    int idx = p.dist - minIndex; // normalize to avoid overflow

                    if (i == 0) first = idx;
                    if (i == size - 1) last = idx;

                    if (node.left != null) {
                        q.add(new Pair(node.left, 2 * idx));
                    }
                    if (node.right != null) {
                        q.add(new Pair(node.right, 2 * idx + 1));
                    }
                }
                maxWidth = Math.max(maxWidth, last - first + 1);
            }

            return maxWidth;
        }
    }
}
