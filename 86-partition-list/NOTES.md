```
class Solution {
public ListNode partition(ListNode head, int x) {
ListNode beforehead = new ListNode(0);
ListNode before = beforehead;
ListNode afterhead = new ListNode(0);
ListNode after = afterhead;
while(head!=null){
if(head.val<x){
before.next=head;
before=head;
}
else{
after.next=head;
after=head;
}
head=head.next;
}
after.next=null;
before.next=afterhead.next;
return beforehead.next;
}
}
```
### another Approach
```
class Solution {
public ListNode partition(ListNode head, int x) {
ListNode le=null,lehead=null;
ListNode ge=null,gehead=null;
ListNode temp=head;
while(temp!=null){
if(temp.val<x){
if(lehead==null){
lehead=temp;
le=temp;
}
else{
le.next=temp;
le=temp;
}
temp=temp.next;
le.next=null;
}
else{
if(gehead==null){
gehead=temp;
ge=temp;
}