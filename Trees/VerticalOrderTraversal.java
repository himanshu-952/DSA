package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    class Solution {
         public class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { data = val; left = null; right = null; }
  }
    static class Tuple {
        TreeNode node;
        int row, col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;

            map
                .computeIfAbsent(col, k -> new TreeMap<>())
                .computeIfAbsent(row, k -> new PriorityQueue<>())
                .offer(node.data);

            if (node.left != null) {
                q.offer(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> vertical = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    vertical.add(nodes.poll());
                }
            }
            result.add(vertical);
        }
        return result;
    }
}

}
