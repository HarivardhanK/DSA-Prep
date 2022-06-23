/*
// Definition for a Node.
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
*/

class Solution {
    private Node dfs(Node n, Map<Integer, Node> vis ) {
        if(vis.containsKey(n.val)) {
            return vis.get(n.val);
        }
        else {
            Node node = new Node(n.val);
            vis.put(node.val, node);
            for(Node nde: n.neighbors) {
                node.neighbors.add(dfs(nde, vis));
            }
            return node;
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Map<Integer, Node> visited = new HashMap<>();
        Node newnode = new Node(node.val);
        visited.put(node.val, newnode);
        
        for(Node n: node.neighbors) {
            newnode.neighbors.add(dfs( n, visited));
        }
            
        return newnode;
    }
}