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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeNode curr = root;
        while(curr!=null || !s.isEmpty()){
            if(curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode temp = s.peek().right;
                if(temp==null){
                    temp=s.pop();
                    ans.add(temp.val);
                    while(!s.isEmpty() && temp==s.peek().right){
                        temp=s.pop();
                        ans.add(temp.val);
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
        return ans;
    }
}