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
   private Map<Integer, Integer> inOrderMap = new HashMap<>();
    private int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

         for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        
        int rootVal = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootVal);

       
        int inOrderIndex = inOrderMap.get(rootVal);

        
        root.left = buildTreeHelper(preorder, left, inOrderIndex - 1);
        root.right = buildTreeHelper(preorder, inOrderIndex + 1, right);

        return root;
    }
}