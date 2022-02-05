/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode mergeLists(ListNode l1,ListNode l2){
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head,tail;
        if(l1.val>l2.val){
            head=l2;
            l2=l2.next;
        }
        else{
            head=l1;
            l1=l1.next;
        }
        tail=head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            }
            else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        if(l1!=null){
            tail.next=l1;
        }
        if(l2!=null){
            tail.next=l2;
        }
        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[lists.length-1];
        ListNode head=lists[0];
        for(int i=1;i<lists.length;i++){
            head=mergeLists(head,lists[i]);
        }
        return head;
    }
}