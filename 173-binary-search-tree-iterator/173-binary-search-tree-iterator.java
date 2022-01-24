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
    ArrayList<Integer> bst = new ArrayList<>();
    int i=0;
    private void bstfill(TreeNode root){
        if(root==null) return;
        bstfill(root.left);
        bst.add(root.val);
        bstfill(root.right);
    }
    public BSTIterator(TreeNode root) {
        bstfill(root);
    }
    
    public int next() {
        if(i>=bst.size()) return -1;
        return bst.get(i++);
    }
    
    public boolean hasNext() {
        return i<bst.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */