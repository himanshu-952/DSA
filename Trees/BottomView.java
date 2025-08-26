package BinaryTrees;

import java.util.*;

public class BottomView {
     public class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { data = val; left = null; right = null; }
  }

  public class Pair{
  TreeNode root ;
  int hd;

  Pair(TreeNode root , Integer hd){
    this.root=root;
    this.hd=hd;
  }
    
  }
  
 class Solution {
    
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // Map hd -> last node's value
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.root;
            int hd = p.hd;

            // overwrite: last node at this hd is the bottom one
            map.put(hd, node.data);

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        // TreeMap keeps keys sorted (left → right)
        res.addAll(map.values());
        return res;
    }
}

}
