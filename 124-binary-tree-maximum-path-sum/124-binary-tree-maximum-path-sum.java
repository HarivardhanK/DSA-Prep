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
        
        int lmax=findmaxpath(root.left);
        int rmax=findmaxpath(root.right);
        int pathsum=root.val;
        if(lmax>0) pathsum+=lmax;
        if(rmax>0) pathsum+=rmax;
        // System.out.println(root.val + " "+pathsum+" "+maxpath);
        int path = root.val+Math.max((lmax>0)?lmax:0 , (rmax>0)?rmax:0);
        maxpath=Math.max(maxpath,pathsum);
        return path;
    }
    public int maxPathSum(TreeNode root) {
        maxpath=root.val;
        findmaxpath(root);
        return maxpath;
    }
}