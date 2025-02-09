/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
     if (root == null) return null;

        // Search for the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Case 1: Node has no children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Node has only one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            // Case 3: Node has two children
            // Find the inorder successor (smallest in right subtree)
            TreeNode successor = findMin(root.right);
            root.val = successor.val;  // Copy successor's value
            root.right = deleteNode(root.right, successor.val); // Delete successor
        }
        
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}