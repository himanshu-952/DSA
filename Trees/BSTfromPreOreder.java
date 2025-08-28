package BinarySearchTrees;

public class BSTfromPreOreder {
    int preIndex=0;
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val ;}
  }
    class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0){
            return null;
        }
        else{
            return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
    }
    private TreeNode helper(int[] preorder, int min , int max){
        if (preIndex == preorder.length) return null;
        if(preorder[preIndex]<min || preorder[preIndex]>max){
            return null;
        }

        TreeNode node= new TreeNode(preorder[preIndex++]);
        node.left= helper(preorder, min, node.val);
        node.right=helper(preorder, node.val, max);

        return node;
    }
}
}
