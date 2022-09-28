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