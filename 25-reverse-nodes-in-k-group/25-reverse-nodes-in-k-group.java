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
    private ListNode reverse(ListNode prev, ListNode curr, ListNode last) {
        ListNode next = (curr != null)?curr.next: last;
        while(curr != last) {
            curr.next = prev;
            prev = curr; 
            curr = next;
            if(next != null) next = next.next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newhead = null, tail = null;
        ListNode prev =  null, curr, next;
        int kk = k;
        while(head != null) {
            kk = k;
            ListNode last = head;
            while(last != null && kk-- > 0) {
                last  = last.next;
            }
            curr = head;
            if(kk <= 0){
                prev = reverse(null, curr, last);
            }
            else {
                prev = head;
            }
            if(newhead == null) {
                newhead = prev;
                // tail = prev;
            }
            else{
                // while(tail.next != null) tail = tail.next;
                tail.next = prev;
            }
            tail = head;
            head = last;
        }
        return newhead;
    }
}