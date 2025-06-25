/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
          node.val = node.next.val;

        // Bypass the next node by pointing to the next of next
        node.next = node.next.next;
    }
}