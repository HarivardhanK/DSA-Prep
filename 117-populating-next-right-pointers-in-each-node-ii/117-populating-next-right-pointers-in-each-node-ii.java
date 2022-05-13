/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        
        while(!q.isEmpty()){
            Queue<Node> nextq = new LinkedList<>();
            while(!q.isEmpty()){
                Node node = q.poll();
                
                if(node.left!=null) nextq.offer(node.left);
                if(node.right!=null) nextq.offer(node.right);
                
                if(!q.isEmpty()) node.next = q.peek();
                else node.next = null;
            }
            q = nextq;
        }
        return root;
    }
}