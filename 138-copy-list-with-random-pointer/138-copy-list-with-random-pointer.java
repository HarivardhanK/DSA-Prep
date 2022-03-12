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
        Node l=head;
        Node ans=null;
        Node tail=null;
        while(l!=null){
            Node node=new Node(l.val);
            if(ans==null){
                ans=node;
                tail=node;
            }
            else{
                tail.next=node;
                tail=tail.next;
            }
            l=l.next;
        }
        l=head;
        tail=ans;
        while(tail!=null&& l!=null){
            if(l.random==null){
                tail.random=null;
            }
            else{
                Node h=head;
                int index=0;
                while(h!=null && h!=l.random){
                    h=h.next;
                    index++;
                }
                h=ans;
                while(index-->0){
                    h=h.next;
                }
                tail.random=h;
            }
            tail=tail.next;
            l=l.next;
        }
        return ans;
    }
}