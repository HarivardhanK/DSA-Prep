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
    public TreeNode searchBST(TreeNode root, int val) {
        //iterative Solution TC: O(logN) SC: O(1)
        while(root!=null && root.val!=val)
            root=root.val>val?root.left:root.right;
        
        return root;
        //Recursive Solution TC: O(logN) SC: O(logN)
        // if(root==null) return null;
        // if(root.val == val) return root;
        // if(root.val>=val)
        //     return searchBST(root.left, val);
        // return searchBST(root.right, val);
    }
}