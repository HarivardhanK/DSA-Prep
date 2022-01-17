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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<TreeNode> temp = new ArrayList<>();
            ans.add(q.get(0).val);
            for(TreeNode node:q){
                if(node.right!=null) temp.add(node.right);
                if(node.left!=null) temp.add(node.left);
            }
            q=temp;
        }
        return ans;
    }
}