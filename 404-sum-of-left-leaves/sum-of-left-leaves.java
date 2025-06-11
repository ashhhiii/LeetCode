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
    public int sumOfLeftLeaves(TreeNode root) {
         if (root == null) return 0;
        
        int sum = 0;
        
        // Check if left child exists and is a leaf
        if (root.left != null && isLeaf(root.left)) {
            sum += root.left.val;
        }
        
        // Recur for left and right subtree
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
    
    // Helper method to check if a node is a leaf
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    
    }
}