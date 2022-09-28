```
class Solution {
private ListNode reverse(ListNode node) {
ListNode curr = node, prev = null, next = node;
while(curr != null) {
if(next != null) next = next.next;
curr.next = prev;
prev = curr;
curr = next;
}
return prev;
}
public ListNode removeNthFromEnd(ListNode head, int n) {
ListNode rev = reverse(head);
ListNode t = rev, prev = null;
while(n-- > 1) {prev = t; t = t.next;}
if(t == rev) rev = rev.next;
else if(t != null && t.next != null) prev.next = t.next;
else prev.next = null;
return reverse(rev);
}
}
```
## Without reversing the linkedlist:
```
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