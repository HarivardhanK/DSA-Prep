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
    public TreeNode dfs(TreeNode root_o, TreeNode root_c, final TreeNode target){
        if(root_c==null) return null;
        
        if(root_o.val==target.val && root_c.val==target.val) return root_c;
        TreeNode left = dfs(root_o.left, root_c.left, target);
        TreeNode right = dfs(root_o.right, root_c.right, target);
        
        return left==null?right:left;
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode root_c = cloned;
        TreeNode root_o = original;
        return dfs(root_o, root_c, target); 
    }
}