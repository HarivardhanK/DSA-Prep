/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head, next = head;
        //step 1: iterate through the list and create a deep copy nodes next its original nodes
        while(curr != null) {
            next = curr.next;
            Node node = new Node(curr.val);
            curr.next = node;
            node.next = next;
            curr = next;
        }
        
        //step 2: now assign random pointer to the deep copies
        curr = head;
        while(curr != null) {
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        
        //step 3: create a dummy node and seperate the deep copy and original copy
        Node dummy = new Node(-1);
        Node deepcopy = dummy;
        curr = head; next = head;
        
        while(curr != null) {
            next = curr.next.next;
            
            //extract the copy
            deepcopy.next = curr.next;
            deepcopy = deepcopy.next;
            
            //restore the original list
            curr.next = next;
            curr = next;
        }
        return dummy.next;
    }
}