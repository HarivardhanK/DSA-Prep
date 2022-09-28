```
/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode() {}
*     ListNode(int val) { this.val = val; }
*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
* }
*/
class Solution {
public ListNode removeNthFromEnd(ListNode head, int n) {
if(head.next==null) return null;
ListNode start = new ListNode(0);
ListNode slow=start,fast=start;
start.next=head;
//moving fast for the n times
while(n-->0) fast=fast.next;
//the n length gap is maintained between them
//so that it creates a distance of fast and slow of n length
//now start moving slow and fast equally
while(fast.next!=null){
fast=fast.next;
slow=slow.next;
}
//there always exists a node after the slow pointer
slow.next=slow.next.next;
return start.next;
}
}
```