import java.util.ArrayList;
import java.util.List;

public class PairSum2 {
     public class TreeNode{
        int val;
        TreeNode left , right;
        public TreeNode(int data){
            this.val=data;
        }
     

}

   public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>();
    dfs(root, targetSum, new ArrayList<>(), res);
    return res;
}

void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> res) {
    if (node == null) return;
    path.add(node.val);
    if (node.left == null && node.right == null && sum == node.val) {
        res.add(new ArrayList<>(path));
    } else {
        dfs(node.left, sum - node.val, path, res);
        dfs(node.right, sum - node.val, path, res);
    }
    path.remove(path.size() - 1);
}}
