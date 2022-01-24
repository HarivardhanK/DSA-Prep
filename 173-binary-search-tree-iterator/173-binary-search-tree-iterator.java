/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    //approach 2 => sc : O(height)
    Stack<TreeNode> s = new Stack<>();
    private void bstleft(TreeNode node){
        while(node!=null){
            s.push(node);
            node=node.left;
        }
    } 
    public BSTIterator(TreeNode root) {
        bstleft(root);
    }
    
    public int next() {
            TreeNode node = s.pop();
            bstleft(node.right);
            return node.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */