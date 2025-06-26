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
    public ListNode sortList(ListNode head) {
      
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Split the list into two halves
        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // Break the link to form two separate lists
        
        // Step 2: Sort each half recursively
        left = sortList(left);
        right = sortList(right);
        
        // Step 3: Merge the two sorted halves
        return merge(left, right);
    }
    
    // Helper function to find the middle node of the linked list
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // Start fast ahead for even list handling
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // Helper function to merge two sorted linked lists
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0); // Dummy node to start the merged list
        ListNode current = dummy;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        
        // Append the remaining nodes from either list (if any)
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }
        
        return dummy.next;
    }
}
