import java.util.ArrayList;
import java.util.List;

public class BinTreePAth {
      public class TreeNode{
        int val;
        TreeNode left , right;
        public TreeNode(int data){
            this.val=data;
        }
     

}
public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    build(root, "", res);
    return res;
}

void build(TreeNode node, String path, List<String> res) {
    if (node == null) return;
    path += node.val;
    if (node.left == null && node.right == null) {
        res.add(path);
        return;
    }
    build(node.left, path + "->", res);
    build(node.right, path + "->", res);
}

}
