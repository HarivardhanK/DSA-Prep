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
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Map<Integer,Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        Node newNode = new Node(node.val);
        visited.put(node.val,newNode);
        
        while(!q.isEmpty()){
            Node n = q.poll();
            Node newn = visited.get(n.val);
            newn.neighbors = new ArrayList<>();
            for(Node it: n.neighbors){
                if(visited.containsKey(it.val)){
                    newn.neighbors.add(visited.get(it.val));
                }
                else{
                    Node newnode = new Node(it.val);
                    visited.put(it.val,newnode);
                    q.offer(it);
                    newn.neighbors.add(newnode);
                }
            }
        }
        return newNode;
    }
}
