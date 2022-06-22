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
class NodeValue {
    int minNode, maxNode, maxSize;
    NodeValue(int min, int max, int size) {
        minNode = min;
        maxNode = max;
        maxSize = size;
    }
}
class Solution {
    int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    int maxsum = 0;
    private NodeValue solve(TreeNode root) {
        if(root == null) 
            return new NodeValue(MAX, MIN, 0);
        
        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);
        
        if(!(left != null && right != null && root.val > left.maxNode && root.val < right.minNode)) 
            return null;
        
        int maxi = root.val + left.maxSize + right.maxSize;
        maxsum = Math.max(maxi, maxsum);
        int min = Math.min(root.val, left.minNode);
        int max = Math.max(root.val, right.maxNode);
        return new NodeValue(min, max, maxi);
    }
    /* 
        simple rule is that
        if largest node on left subtree is less than root 
        if smallest node on right subtree is greater then root then it is a BST
    */
    public int maxSumBST(TreeNode root) {
        solve(root);
        return maxsum;
    }
}