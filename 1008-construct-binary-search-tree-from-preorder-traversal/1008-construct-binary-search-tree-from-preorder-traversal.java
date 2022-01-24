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
    public TreeNode bst(int pre[], int upbound, int[] i){
        
        if(pre.length==i[0] || upbound<pre[i[0]]) return null;
        TreeNode root = new TreeNode(pre[i[0]++]);
        root.left = bst(pre, root.val, i);
        root.right = bst(pre, upbound, i);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder,Integer.MAX_VALUE,new int[]{0});
    }
}