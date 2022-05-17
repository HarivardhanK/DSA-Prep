// { Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    private static void buildMap(Node root, Map<Node, Node> map){
        Queue<Node>  q = new LinkedList<>();
        q.offer(root);
        map.put(root,null);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.left!=null){
                q.offer(node.left);
                map.put(node.left, node);
            }
            if(node.right!=null){
                q.offer(node.right);
                map.put(node.right, node);
            }
        }
    }
    private static Node findTarget(Node root, int target){
        if(root==null || root.data==target) return root;
        
        Node left = findTarget(root.left,target);
        Node right = findTarget(root.right,target);
        
        return left==null?right:left;
    }
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        Map<Node, Node> map = new HashMap<>();
        buildMap(root, map);
        Node targetNode = findTarget(root, target);
        Set<Node> visited = new HashSet<>();
        int timetaken = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(targetNode);
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Node node = q.poll();
                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    q.offer(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    q.offer(node.right);
                }
                Node parent = map.get(node);
                if(parent != null && !visited.contains(parent)){
                    visited.add(parent);
                    q.offer(parent);
                }
            }
            timetaken++;
        }
        return timetaken-1;
    }
}