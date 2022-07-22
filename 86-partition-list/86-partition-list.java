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
        ListNode beforex = new ListNode();
        ListNode before = beforex;
        ListNode afterx = new ListNode();
        ListNode after = afterx;
        
        while(head != null) {
            if(head.val < x) {
                before.next = head;
                before = head;
            }
            else {
                after.next = head;
                after = head;
            }
            head = head.next;
        }
        
        after.next = null;
        before.next = afterx.next;
        return beforex.next;
    }
}