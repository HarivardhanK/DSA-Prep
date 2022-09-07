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
    void solve(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.append("("+root.val);
        solve(root.left, sb);
        if(root.left == null && root.right != null) sb.append("()");
        solve(root.right, sb);
        sb.append(")");
    }
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        solve(root, sb);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}