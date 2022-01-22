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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         Map<Integer, Integer> mapInorder = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            mapInorder.put(inorder[i],i);
        
        return builtTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, mapInorder);
    
    }
    
    public TreeNode builtTree (int []post, int ps, int pe ,int[] in, int is, int ie, Map<Integer,Integer> mapIn){
        if(ps>pe || is>ie || ps<0 || is<0) return null;
        
        TreeNode root = new TreeNode(post[pe]);
        int inRoot = mapIn.get(root.val);
        int inLeft = inRoot-is;
        
        root.left = builtTree(post, ps, ps+inLeft-1, in, is, inRoot-1, mapIn);
        root.right = builtTree(post, ps+inLeft, pe-1, in, inRoot+1, ie, mapIn);
        
        return root;
    }
}