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
    List<List<Integer>> ans;
    private void pathsum(TreeNode root, int tar, List<Integer> pl) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            pl.add(root.val);
            if(tar == root.val)
                ans.add(new ArrayList<>(pl));
            pl.remove(pl.size()-1);
            return;
        }
        
        tar -= root.val;
        pl.add(root.val);
        pathsum(root.left, tar, pl);
        pathsum(root.right, tar, pl);
        pl.remove(pl.size()-1);
        
    } 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        pathsum(root, targetSum, new ArrayList<>());
        return ans;
    }
}