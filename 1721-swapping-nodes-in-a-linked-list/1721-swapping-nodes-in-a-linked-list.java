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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast=head;
        while(fast!=null && k-->1){
            fast=fast.next;
        }
        ListNode swap1=fast;
        ListNode slow=head;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        if(slow!=null && swap1!=null){
            // System.out.println(swap1.val + " "+slow.val);
            int temp = slow.val;
            slow.val=swap1.val;
            swap1.val=temp;
        }
        return head;
    }
}