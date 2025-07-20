public class DiameterOfTree {

    public static class Node {
        int val;
        Node left, right;

        public Node(int v) {
            this.val = v;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        int height, diam;
        public Info(int h, int d) {
            this.height = h;
            this.diam = d;
        }
    }

    public static Info diamOfTree(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diamOfTree(root.left);
        Info rightInfo = diamOfTree(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int diamThroughRoot = leftInfo.height + rightInfo.height + 1;
        int maxDiam = Math.max(diamThroughRoot, Math.max(leftInfo.diam, rightInfo.diam));

        return new Info(height, maxDiam);
    }

    
}
