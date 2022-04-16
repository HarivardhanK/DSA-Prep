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
    int sum=0;
    private void convbst(TreeNode root){
        if(root==null) return;
        convbst(root.right);
        int temp = root.val;
        root.val+=sum;
        sum+=temp;
        convbst(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
        convbst(root);
        return root;
    }
}