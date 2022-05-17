/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode dfs(TreeNode root,final TreeNode target){
        if(root==null) return null;
        
        if(root.val==target.val) return root;
        TreeNode left = dfs(root.left, target);
        TreeNode right = dfs(root.right, target);
        
        return left==null?right:left;
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode root = cloned;
        return dfs(root, target); 
    }
}