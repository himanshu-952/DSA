package Graphs;
import java.util.*;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;

            Map<Node, Node> map = new HashMap<>(); 
            Queue<Node> queue = new LinkedList<>();

            // create clone 
            Node cloneStart = new Node(node.val);
            map.put(node, cloneStart);
            queue.offer(node);

            while (!queue.isEmpty()) {
                Node curr = queue.poll();

                // Traverse neighbors
                for (Node neighbor : curr.neighbors) {
                    if (!map.containsKey(neighbor)) {
                        // clone the neighbor
                        map.put(neighbor, new Node(neighbor.val));
                        queue.offer(neighbor);
                    }
                    // connect 
                    map.get(curr).neighbors.add(map.get(neighbor));
                }
            }
            return cloneStart;
        }
    }
}
