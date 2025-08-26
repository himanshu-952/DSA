package BinaryTrees;

import java.util.HashMap;

public class ConstructFromInPre {
    int preIndex=0;
    HashMap<Integer , Integer> hm ;
     public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int val) { this.val = val;}
        }
    class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i] , i);
        }
         
        return helper(preorder, 0, inorder.length-1);
        
    }
    public TreeNode helper(int[] preorder, int st , int end){
        if(st>end){
            return null;
        }
        int curr= preorder[preIndex++];
        TreeNode root = new TreeNode(curr);

        int currIndex=hm.get(curr);

        root.left=helper(preorder, st, currIndex-1);
        root.right=helper(preorder, currIndex+1, end);

        return root;
    }
}
}
