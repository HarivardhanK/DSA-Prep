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
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int ans=0;
        if(root.left!=null)
            ans=maxDepth(root.left);
        if(root.right!=null)
            ans=Math.max(ans,maxDepth(root.right));
        return ans+1;
    }
}