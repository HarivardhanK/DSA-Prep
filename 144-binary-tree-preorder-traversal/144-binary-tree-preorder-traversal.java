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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<>();
        //stack ds
        Stack<TreeNode> s = new Stack<>();
        //pushing the root element first
        s.push(root);
        while(!s.isEmpty()){
            int size = s.size();
            TreeNode temp;
            while(size-->0){
                //pop the top most element(which is left)
                temp = s.pop();
                // pushing the right node first
                if(temp.right!=null)
                    s.push(temp.right);
                //then pushing the left node into the stack
                if(temp.left!=null)
                    s.push(temp.left);
                //add the value of that element into the list 
                ans.add(temp.val);
            }
        }
        return ans;
    }
}