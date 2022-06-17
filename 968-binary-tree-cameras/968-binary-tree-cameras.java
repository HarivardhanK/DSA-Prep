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
    int Monitored = 0, Is_camera = 1, Need_camera = -1;
    int count = 0;
    public int minCameraCover(TreeNode root) {
        int treeInfo = treeInfo(root);
        
        if(treeInfo == Need_camera) {
            return count + 1;
        }
        
        return count;
    }
    private int treeInfo(TreeNode root) {
        if(root == null) return Monitored;
        
        int left = treeInfo(root.left);
        int right = treeInfo(root.right);
        
        if(left == Need_camera || right == Need_camera) {
            count++;
            return Is_camera;
        }
        else if(left == Is_camera || right == Is_camera)
            return Monitored;
        
        return Need_camera;
    }
}