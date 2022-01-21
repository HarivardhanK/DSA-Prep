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
    public TreeNode builtTree (int []pre, int[] in, Map<Integer,Integer> mapIn, int ps, int is , int pe ,int ie){
        if(ps>pe || is>ie) return null;
        
        TreeNode root = new TreeNode(pre[ps]);
        int inRoot = mapIn.get(root.val);
        int inLeft = inRoot - is;
        
        root.left = builtTree(pre, in, mapIn, ps+1, is, ps+inLeft, inRoot-1);
        root.right = builtTree(pre, in, mapIn, ps+inLeft+1, inRoot+1, pe, ie);
        
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mapInorder = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            mapInorder.put(inorder[i],i);
        
        return builtTree(preorder, inorder, mapInorder,0, 0, preorder.length-1, inorder.length-1);
    }
}





