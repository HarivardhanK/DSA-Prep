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
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        if(curr != null) next = curr.next;
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        
        ListNode mid = findMid(head);
        ListNode revList = reverse(mid.next);
        mid.next = null;
        
        while(head != null && revList != null) {
            if(head.val != revList.val) return false;
            head = head.next;
            revList = revList.next;
        }
        return true;
    }
}