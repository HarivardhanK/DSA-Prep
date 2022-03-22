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
else{
ge.next=temp;
ge=temp;
}
temp=temp.next;
ge.next=null;
}
}
if(lehead==null) return gehead;
else le.next=gehead;
return lehead;
}
}
```