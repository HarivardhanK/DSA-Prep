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
    private Node dfs(Node n,Node copy, Map<Integer, Node> vis ) {
        vis.put(n.val, copy);
        for(Node node: n.neighbors) {
            if(vis.containsKey(node.val)) {
                copy.neighbors.add(vis.get(node.val));
            }
            else {
                Node newnode = new Node(node.val);
                copy.neighbors.add(dfs(node, newnode, vis));
            }
        }
        return copy;
        
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Map<Integer, Node> visited = new HashMap<>();
        Node newnode = new Node(node.val);
        
        dfs(node, newnode, visited);
        return newnode;
    }
}