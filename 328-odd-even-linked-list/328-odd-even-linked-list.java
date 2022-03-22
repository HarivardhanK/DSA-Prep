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
    public ListNode oddEvenList(ListNode head) {
        ListNode evenhead=new ListNode(0);
        ListNode even = evenhead;
        ListNode oddhead=new ListNode(0);
        ListNode odd=oddhead;
        while(head!=null){
            even.next=head;
            even=head;
            head=head.next;
            odd.next=head;
            odd=head;
            if(head!=null)
                head=head.next;
        }
        if(odd!=null)odd.next=null;
        even.next=oddhead.next;
        return evenhead.next;
    }
}