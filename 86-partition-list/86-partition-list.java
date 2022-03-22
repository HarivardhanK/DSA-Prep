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