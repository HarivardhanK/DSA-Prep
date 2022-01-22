/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        
        StringBuilder treestr=new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                treestr.append("n ");
                continue;
            }
            else{
                q.offer(node.left);
                q.offer(node.right);
            }
            treestr.append(node.val+" ");
        }
        return treestr.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        String[] vals = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.offer(root);
        int i=1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode node = q.poll();
                if(!vals[i].equals("n")){
                    TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                    node.left = left;
                    q.offer(left);
                }
                else{
                    node.left = null;
                }
                i++;
                if(!vals[i].equals("n")){
                    TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                    node.right = right;
                    q.offer(right);
                }
                else{
                    node.right = null;
                }
                i++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));