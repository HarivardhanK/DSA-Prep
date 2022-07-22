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
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            if(temp.val < x)
                arr.add(temp.val);
            temp = temp.next;
        }
        
        ListNode root = null;
        temp = null;
        for(int ele: arr) {
            ListNode newnode = new ListNode(ele);
            if(root == null) {
                root = newnode;
            }
            else{
                temp.next = newnode;
            }
            temp = newnode;
        }
        
        arr.removeAll(arr);
        
        while(head != null) {
            if(head.val >= x) arr.add(head.val);
            head = head.next;
        }
        
        for(int ele: arr) {
            ListNode newnode = new ListNode(ele);
            if(root == null) {
                root = newnode;
                temp = newnode;
            }
            else{
                temp.next = newnode;
                temp = newnode;
            }
        }
        return root;
    }
}