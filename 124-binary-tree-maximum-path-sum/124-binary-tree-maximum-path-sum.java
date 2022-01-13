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
    int maxpath;
    private int findmaxpath(TreeNode root){
        if(root==null) return 0;
        
        int lmax=Math.max(0,findmaxpath(root.left));
        int rmax=Math.max(0,findmaxpath(root.right));
        
        maxpath=Math.max(maxpath,root.val+lmax+rmax);
        return root.val+Math.max(lmax , rmax);
    }
    public int maxPathSum(TreeNode root) {
        maxpath=root.val;
        findmaxpath(root);
        return maxpath;
    }
}