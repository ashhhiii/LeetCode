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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxSum;
    }

    private int findMaxPath(TreeNode node) {
        if (node == null) return 0;

        // Compute the maximum path sum through left and right children
        int leftMax = Math.max(0, findMaxPath(node.left));
        int rightMax = Math.max(0, findMaxPath(node.right));

        // Calculate the potential max path sum including the current node
        int currentPathSum = node.val + leftMax + rightMax;

        // Update the global maximum sum if needed
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum path sum extending from this node to one of its children
        return node.val + Math.max(leftMax, rightMax);
    }
}