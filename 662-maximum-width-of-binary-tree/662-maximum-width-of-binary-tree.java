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
class Pair{
    TreeNode node; int ind;
    Pair(TreeNode node, int ind){
        this.node= node;
        this.ind=ind;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int width=0;
        if(root==null) return width;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().ind;
            int max=min;
            while(size-->0){
                Pair p = q.poll();
                TreeNode node = p.node;
                int ind= p.ind - min;
                max=p.ind;
                if(node.left!=null) q.offer(new Pair(node.left, 2*ind+1));
                if(node.right!=null) q.offer(new Pair(node.right, 2*ind+2));
            }
            width = Math.max(max-min+1, width);
        }
        return width;
    }
}