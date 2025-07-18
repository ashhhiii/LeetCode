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
    private int maxSum = Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        findMaxSum(root);
        return maxSum;
    }
    private int findMaxSum(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftMax = Math.max(0 , findMaxSum(node.left));
        int rightMax = Math.max(0 , findMaxSum(node.right));

        int currentSum = node.val + leftMax + rightMax;
        maxSum = Math.max(maxSum , currentSum);

        return node.val + Math.max(leftMax , rightMax);
    }
}