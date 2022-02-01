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
    int leftmostnode;
    int maxlevel;
    void dfspreorder(TreeNode root, int level){
        if(root==null) return;
        if(level>maxlevel){
            maxlevel=level;
            leftmostnode=root.val;
        }
        dfspreorder(root.left, level+1);
        dfspreorder(root.right, level+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        leftmostnode=root.val;
        maxlevel=-1;
        dfspreorder(root,0);
        return leftmostnode;
    }
}