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
        int pn=0;
        q.offer(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left!=null){
                q.offer(temp.left);
            }
            if(temp.right!=null){
                q.offer(temp.right);
            }
            if(pn==0 || (q.size())==pn){
                temp.next=null;
                pn=q.size()*2;
            }
            else 
                temp.next=q.peek();
        }
        return root;
    }
}