import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree {
     public class TreeNode{
        int val;
        TreeNode left , right;
        public TreeNode(int data){
            this.val=data;
        }
     

}
public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> leaves1 = new ArrayList<>(), leaves2 = new ArrayList<>();
    dfs(root1, leaves1);
    dfs(root2, leaves2);
    return leaves1.equals(leaves2);
}

void dfs(TreeNode node, List<Integer> list) {
    if (node == null) return;
    if (node.left == null && node.right == null) {
        list.add(node.val);
    }
    dfs(node.left, list);
    dfs(node.right, list);
}

}
