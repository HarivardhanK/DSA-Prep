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
    ArrayList<String> ans;
    private void sumStrings(TreeNode root, String p){
        if(root.right==null && root.left==null){
            ans.add(p+root.val);
            return;
        }
        if(root.right!=null)
            sumStrings(root.right,p+root.val);
        if(root.left!=null)
            sumStrings(root.left, p+root.val);
    }
    public int sumNumbers(TreeNode root) {
        ans= new ArrayList<>();
        String p = "";
        sumStrings(root, p);
        int sum=0;
        for(String s: ans){
            sum+=Integer.parseInt(s);
        }
        return sum;
    }
}