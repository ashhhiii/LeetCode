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
    private Map<Integer,Integer> inorderMap;
    private int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        preorderIndex=0;

        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);

        }
        return buildTreeHelper(preorder,0,inorder.length-1);
        
    }
    private TreeNode buildTreeHelper(int[] preorder,int left,int right){
         if (left > right) {
            return null;
        }
        
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        int inorderIndex = inorderMap.get(rootValue);
        
        root.left = buildTreeHelper(preorder, left, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorderIndex + 1, right);
        
        return root;
    
    }
}