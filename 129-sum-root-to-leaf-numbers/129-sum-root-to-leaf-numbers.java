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
    private int sumNumber(TreeNode root, int sum){
        if(root.right == null && root.left==null){
            sum= sum*10 + root.val;
            return sum;
        }
        sum=(sum*10)+root.val;
        int left=0, right=0;
        if(root.right!=null)
            left = sumNumber(root.right, sum);
        if(root.left!=null)
            right = sumNumber(root.left, sum);
        return left+ right;
    }
    public int sumNumbers(TreeNode root) {
       return sumNumber(root,0); 
    }
}