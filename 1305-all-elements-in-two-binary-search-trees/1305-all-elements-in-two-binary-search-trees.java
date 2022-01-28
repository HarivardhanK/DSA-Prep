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
    List<Integer> inorder(TreeNode root){
        if(root==null) return new ArrayList<>();
        List<Integer> ans = inorder(root.left);
        ans.add(root.val);
        ans.addAll(inorder(root.right));
        return ans;
    }
    List<Integer> mergeLists(List<Integer> bst1, List<Integer> bst2){
        int i=0, j=0;
        List<Integer> bst=new ArrayList<>();
        while(i<bst1.size() && j<bst2.size()){
            if(bst1.get(i) < bst2.get(j)) bst.add(bst1.get(i++));
            else bst.add(bst2.get(j++));
        }
        while(i<bst1.size()) bst.add(bst1.get(i++));
        while(j<bst2.size()) bst.add(bst2.get(j++));
        return bst;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> bst1 = inorder(root1);
        List<Integer> bst2 = inorder(root2);
        return mergeLists(bst1, bst2);
    }
}