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
    private ListNode recur(ListNode prev, ListNode curr, ListNode next) {
        if(curr == null) 
            return prev;
        
        curr.next = prev;
        prev = curr;
        curr = next;
        next = (next == null)?null:next.next;
        
        return recur(prev, curr, next);
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        return recur(null, head, head.next);
    }
}