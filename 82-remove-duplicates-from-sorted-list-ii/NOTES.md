while(curr.next!=null){
if(prev!=null && prev.val!=curr.val && curr.val!=curr.next.val){
if(newHead==null){
newHead = new ListNode(curr.val,null);
temp=newHead;
}
else{
ListNode node=new ListNode(curr.val,null);
temp.next=node;
temp=temp.next;
}
}
prev=curr;
curr=curr.next;
}
//again as for the beginning we check for the ending too
if(prev.val!=curr.val){
ListNode node=new ListNode(curr.val,null);
temp=newHead;
//if all elements in the list are duplis except the last one
//then we directly return the last node
if(newHead==null) return curr;
while(temp.next!=null) temp=temp.next;
temp.next=node;
}
return newHead;
}
}
```
​