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
    private TreeNode builtTree(int[] nums, int s, int e){
        if(s>e) return null;
        int max = nums[s],maxi=s;
        for(int i=s;i<=e;i++){
            if(max<nums[i]){
                max=nums[i];
                maxi=i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = builtTree(nums,s,maxi-1);
        root.right = builtTree(nums,maxi+1,e);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return builtTree(nums,0,nums.length-1);
    }
}