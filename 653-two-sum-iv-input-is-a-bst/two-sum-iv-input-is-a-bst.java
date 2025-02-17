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
    
    public boolean findTarget(TreeNode root, int k) {
      List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);

        int left = 0, right = inorderList.size() - 1;
        while (left < right) {
            int sum = inorderList.get(left) + inorderList.get(right);
            if (sum == k) return true;
            else if (sum < k) left++;
            else right--;
        }
        return false;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }
}

