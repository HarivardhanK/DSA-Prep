// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            solver x = new solver();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        }
    }
}

// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class solver{
    static Map<Node, Node> CreateNodeToParent(Node root){
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        map.put(root,null);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.left!=null){
                map.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                map.put(node.right, node);
                q.offer(node.right);
            }
        }
        return map;
    }
    static Node inorder(Node root, int tar){
        if(root==null || root.data == tar) return root;
        
        Node left = inorder(root.left, tar);
        Node right = inorder(root.right, tar);
        
        return (left==null)?right:left;
    }
    static int sum_at_distK(Node root, int target, int k){
        Map<Node,Node> nodepar = CreateNodeToParent(root);
        Node start = inorder(root, target);
        Set<Node> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        int sum = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                 Node node = q.poll();
                 sum +=node.data;
                //  System.out.println(sum);
                 if(!set.contains(node.left) && node.left!=null){
                     q.offer(node.left);
                 }
                 if(!set.contains(node.right) && node.right!=null){
                     q.offer(node.right);
                 }
                 Node par = nodepar.get(node);
                 if(par!=null && !set.contains(par)){
                     q.offer(par);
                 }
                 set.add(node);
            }
            k--;
            if(k<0) break;
        }
        return sum;
    }
}

