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
// which stores the lowerbound, upperbound and maxsum
class NodeValue {
    int minNode, maxNode, maxSize;
    NodeValue(int min, int max, int size) {
        minNode = min;
        maxNode = max;
        maxSize = size;
    }
}
class Solution {
// global variables
    int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    int maxsum = 0;

    private NodeValue solve(TreeNode root) {
        if(root == null) 
            return new NodeValue(MAX, MIN, 0);

        //post order traversal
        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);

                //not a valid BST
        if(!(left != null && right != null && root.val > left.maxNode && root.val < right.minNode)) 
            return null;

                // update the maximum sum
        int maxi = root.val + left.maxSize + right.maxSize;
        maxsum = Math.max(maxi, maxsum);

                //update the lower bound and the upper bound of the current node
        int min = Math.min(root.val, left.minNode);
        int max = Math.max(root.val, right.maxNode);

        return new NodeValue(min, max, maxi);
    }

    public int maxSumBST(TreeNode root) {
        solve(root);
        return maxsum;
    }
}