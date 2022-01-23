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
    public TreeNode findRight(TreeNode node){
        if(node.right==null) return node;
        return findRight(node.right);
    }
    public TreeNode helper(TreeNode node){
        if(node.left==null) return node.right;
        else if(node.right==null) return node.left;
        
        TreeNode rightchild = node.right;
        TreeNode rightmostnode = findRight(node.left);
        rightmostnode.right = rightchild;
        return node.left;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        TreeNode node = root;
        
        if(root.val == key) return helper(root);
        
        while(node!=null){
             if(node.val>=key){  
                 if(node.left!=null && node.left.val==key){
                     node.left=helper(node.left);
                     break;
                 }   
                 else node = node.left;
             }
             else{
                if(node.right!=null && node.right.val==key){
                     node.right = helper(node.right);
                     break;
                }
                else node = node.right;
            }
        }
        return root;
    }
}