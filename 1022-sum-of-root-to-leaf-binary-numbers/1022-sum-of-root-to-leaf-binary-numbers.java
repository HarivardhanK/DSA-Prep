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
    ArrayList<String> ans ;
    private void sumOfString(TreeNode root, String p){
        if(root.right==null && root.left==null){
            ans.add(p+root.val);
            return;
        }
        if(root.right!=null)
            sumOfString(root.right,p+root.val);
        if(root.left!=null)
            sumOfString(root.left,p+root.val);
    }
    public int sumRootToLeaf(TreeNode root) {
        String p = "";
        ans = new ArrayList<>();
        sumOfString(root, p);
        int power=1;
        int sum=0;
        for(String s: ans){
            power=1;
            int smallans=0;
            for(int i=s.length()-1;i>=0;i--){
                smallans+=(int)(s.charAt(i)-'0')*power;
                power*=2;
            }
            sum+=smallans;
        }
        return sum;
    }
}