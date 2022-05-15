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
    private Pair<Integer, Integer> inorder(TreeNode root,int level){
        if(root==null) return new Pair<>(-1,-1);
        if(root.left==null && root.right==null) return new Pair<>(level,root.val);
        
        Pair<Integer, Integer> left = inorder(root.left,level+1);
        Pair<Integer, Integer> right = inorder(root.right,level+1);
        
        if(left.getKey()==right.getKey()) return new Pair<>(left.getKey(),left.getValue()+right.getValue());
        else if(left.getKey()>right.getKey()) return left;
        return right;
    }
    public int deepestLeavesSum(TreeNode root) {
        return inorder(root,0).getValue();
    }
}