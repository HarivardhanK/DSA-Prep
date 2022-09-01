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
    int solve(TreeNode root, int max) {
        if(root == null) return 0;
        max = Math.max(max, root.val);
        
        int ans = solve(root.left, max);
        
        if(root.val >= max)  ans++;
        
        ans += solve(root.right, max);
        return ans;
    }
    public int goodNodes(TreeNode root) {
        return solve(root, Integer.MIN_VALUE);
    }
}