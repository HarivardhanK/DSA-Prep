/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        q.offer(root);
        
        while(q.size() > 0) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            while(size-- > 0) {
                Node node = q.poll();
                level.add(node.val);
                for(Node it: node.children) {
                    q.offer(it);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}