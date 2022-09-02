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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.size() > 0) {
            int size = q.size();
            double n = size;
            double sum = 0;
            while(size-- > 0) {
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                sum += node.val;
            }
            ans.add(sum/n);
        }
        return ans;
    }
}