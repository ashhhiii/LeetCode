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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow  = head;
        ListNode prev  = null;

        while(fast != null && fast.next != null){
             prev = slow; // Update the previous node
            slow = slow.next; // Move slow one step
            fast = fast.next.next; 
        }
        prev.next = slow.next;
        return head;

    }
}