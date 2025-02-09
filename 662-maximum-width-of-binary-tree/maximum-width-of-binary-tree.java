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
    
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int currIndex = current.index - minIndex;
                if (i == 0) first = currIndex;
                if (i == size - 1) last = currIndex;
                if (current.node.left != null) queue.offer(new Pair(current.node.left, currIndex * 2));
                if (current.node.right != null) queue.offer(new Pair(current.node.right, currIndex * 2 + 1));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}

class Pair {
    TreeNode node;
    int index;
    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
