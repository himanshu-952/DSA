package BinaryTrees;

import java.util.HashMap;
import java.util.Map;

public class ConstructFromInPost {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int val) { this.val = val;}
        }
    class Solution {

    int postIndex;
    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        postIndex = postorder.length - 1; // start from last element
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderMap.get(rootVal);

        //build right subtree first
        root.right = helper(postorder, inIndex + 1, inEnd);
        root.left = helper(postorder, inStart, inIndex - 1);

        return root;
    }
}

}
