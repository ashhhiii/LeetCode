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

    // Find the middle of the linked list
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Move slow pointer by one and fast pointer by two
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Middle node
    }

    // Reverse the linked list from the given node
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;  // Store the next node
            current.next = prev;           // Reverse the current node's pointer
            prev = current;                // Move prev to the current node
            current = next;                // Move to the next node
        }
        return prev; // New head of the reversed list
    }

    // Reorder the linked list
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;  // No need to reorder if the list is empty or has only one node
        }
        
        // Step 1: Find the middle of the list
        ListNode mid = middleNode(head);

        // Step 2: Reverse the second half of the list
        ListNode secondHalfReversed = reverseList(mid.next);
        mid.next = null;  // Split the list into two halves
        
        // Step 3: Merge the two halves alternately
        ListNode firstHalf = head;
        ListNode secondHalf = secondHalfReversed;
        
        while (secondHalf != null) {
            // Save next nodes
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;
            
            // Interleave the nodes
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            
            // Move to the next nodes
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }
}
