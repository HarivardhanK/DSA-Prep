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
    int count = 0;
    private void preorder(TreeNode root, int path) {
        if(root != null) {
            path = path ^ (1<<root.val);
            
            if(root.left == null && root.right == null) {
                if((path&(path-1)) == 0) 
                    count++;
            }
            preorder(root.left, path);
            preorder(root.right, path);
        }
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        preorder(root, 0);
        return count;
    }
}