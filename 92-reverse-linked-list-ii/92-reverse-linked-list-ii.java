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
    private ListNode reverseLL( ListNode curr, ListNode temp) {
        ListNode next = null, prev = null;
        if(curr != null) next = curr.next;
        
        while(curr != temp) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr!= null) next = next.next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode curr = head, prev = null;
        for(int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }
        
        ListNode temp = head;
        for(int i = 1; i <= right && temp != null ; i++) 
            temp = temp.next;
        
        ListNode start = reverseLL(curr, temp);
        
        curr = start;
        while(start != null && start.next != null) start = start.next;
        
        start.next = temp;
        if(prev == null) {
            return curr;
        }
        prev.next = curr;
        return head;
    }
}