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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;  // No need to reverse if k is 1 or list is empty
        }

        // Dummy node to handle the head of the list uniformly
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k && kthNode != null; i++) {
                kthNode = kthNode.next;
            }
            if (kthNode == null) {
                break;  // Not enough nodes to reverse in the current group
            }

            // Reverse k nodes
            ListNode current = prevGroupEnd.next;
            ListNode prev = null;
            ListNode next = null;
            ListNode firstNodeOfGroup = current;

            for (int i = 0; i < k; i++) {
                next = current.next;   // Store next node
                current.next = prev;   // Reverse current node's pointer
                prev = current;        // Move prev to current node
                current = next;        // Move to the next node
            }

            // Connect the reversed group with the previous part and the next part
            prevGroupEnd.next = prev;              // prev is now the new head of this group
            firstNodeOfGroup.next = current;       // Connect with the next group
            prevGroupEnd = firstNodeOfGroup;       // Move to the end of the current group
        }

        return dummy.next;  // Return the new head
    }
}