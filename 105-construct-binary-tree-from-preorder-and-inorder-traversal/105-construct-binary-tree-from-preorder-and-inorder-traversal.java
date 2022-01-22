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
    public TreeNode builtTree (int []pre, int ps, int pe, int[] in, int is, int ie, Map<Integer,Integer> mapIn){
        if(ps>pe || is>ie) return null;
        
        TreeNode root = new TreeNode(pre[ps]);
        int inRoot = mapIn.get(root.val);
        int inLeft = inRoot - is;
        
        root.left = builtTree(pre, ps+1, ps+inLeft, in, is, inRoot-1,mapIn);
        root.right = builtTree(pre, ps+inLeft+1, pe, in, inRoot+1, ie, mapIn);
        
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mapInorder = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            mapInorder.put(inorder[i],i);
        
        return builtTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, mapInorder);
    }
}





