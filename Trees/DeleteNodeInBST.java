public class DeleteNodeInBST {
    static Node root;

    static class Node {
        int data;
        Node leftnode, rightnode;

        public Node(int data) {
            this.data = data;
            this.leftnode = null;
            this.rightnode = null;
        }
    }

    // MAIN delete function
    public static Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.leftnode = delete(root.leftnode, key);
        } else if (key > root.data) {
            root.rightnode = delete(root.rightnode, key);
        } else {
            // Node to be deleted found

            // Case 1: No child
            if (root.leftnode == null && root.rightnode == null) {
                return null;
            }

            // Case 2: One child
            if (root.leftnode == null) return root.rightnode;
            if (root.rightnode == null) return root.leftnode;

            // Case 3: Two children
            Node successor = findMin(root.rightnode);
            root.data = successor.data;
            root.rightnode = delete(root.rightnode, successor.data);
        }

        return root;
    }

    // Helper to find the inorder successor (minimum node in right subtree)
    public static Node findMin(Node root) {
        while (root.leftnode != null) {
            root = root.leftnode;
        }
        return root;
    }

   

   
}
