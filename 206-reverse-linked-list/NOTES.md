### Iteratively
```
class Solution {
public ListNode reverseList(ListNode head) {
if(head == null || head.next == null)
return head;
ListNode prev = null, curr = head, next = curr.next;
​
while(curr != null) {
curr.next = prev;
prev = curr;
curr = next;
if(next != null)
next = next.next;
}
return prev;
}
}
```
​
### Recursively
​
```
​
```