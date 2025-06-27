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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;  // No change needed if the list is empty or positions are the same
        }
        
        ListNode dummy = new ListNode(0);  // Create a dummy node to handle edge cases
        dummy.next = head;
        ListNode prev = dummy;
        
        // Step 1: Move `prev` to the node before the `left` position
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        // `current` now points to the `left` node
        ListNode current = prev.next;
        ListNode next = null;
        
        // Step 2: Reverse the sublist from `left` to `right`
        for (int i = 0; i < (right - left); i++) {
            next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        
        return dummy.next;  // Return the modified list
    }
        
    }
