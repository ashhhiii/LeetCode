/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        findPaths(root, new ArrayList<>(), result);
        return result;
    }
    
    private static void findPaths(TreeNode node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (node == null) return;
        
        path.add(node.val);
        
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            findPaths(node.left, path, result);
            findPaths(node.right, path, result);
        }
        
        path.remove(path.size() - 1);
    }
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
}