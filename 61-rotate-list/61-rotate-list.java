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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode temp = head;
        int n=0;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        k=k%n;
        if(k==0) return head;
        int stepsToMoveForward=n-k;
        ListNode prev=null;
        temp = head;
        while(temp!=null && stepsToMoveForward-->0){
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
        ListNode newHead = temp;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        return newHead;
    }
}