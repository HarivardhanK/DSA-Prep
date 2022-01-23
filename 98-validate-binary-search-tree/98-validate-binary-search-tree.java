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
class Solution {
    public boolean isvalid(TreeNode root, long lower, long upper){
        if(root == null) return true;
        if(root.val<=lower || root.val>=upper) return false;
        return isvalid(root.left, lower, root.val) && isvalid(root.right, root.val, upper);
        
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isvalid(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }
}