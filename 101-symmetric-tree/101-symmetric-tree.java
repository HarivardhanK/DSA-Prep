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
    boolean isSym(TreeNode r , TreeNode l){
        //these two stmt can written as below one line stmt 
        //both are same but below(2) looks clean than (1)
        // 1. 
        // if(l==null && r==null) return true;
        // if((l==null && r!=null)|| (l!=null && r==null) ) return false;
        //2.
        if(r==null || l==null) return l==r;

        if(l.val!=r.val) return false;
        return isSym(r.right,l.left) && isSym(r.left,l.right);
    }
    public boolean isSymmetric(TreeNode root) {
        return isSym(root.right,root.left);
    }
}