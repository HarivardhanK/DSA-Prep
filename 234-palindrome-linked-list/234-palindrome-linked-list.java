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
    private ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next; 
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev  = null, curr = head, next = (curr == null)?null:curr.next;
        while(curr != null ) {
            curr.next = prev;
            prev =curr;
            curr = next;
            next = (next == null)?null:next.next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        //reverse the half of the linked list
        ListNode mid = middleNode(head);
        ListNode tail = reverse(mid);
        //check for pallindrome or not
        while(tail != null && head != null) {
            if(tail.val != head.val) 
                return false;
            tail = tail.next;
            head = head.next;
        }
        return true;
    }
}