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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        TreeMap<Integer, List<int[]>> columnMap = new TreeMap<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0});
        
        while (!queue.isEmpty()) {
            Object[] nodeData = queue.poll();
            TreeNode node = (TreeNode) nodeData[0];
            int row = (int) nodeData[1];
            int col = (int) nodeData[2];
            
            columnMap.putIfAbsent(col, new ArrayList<>());
            columnMap.get(col).add(new int[]{row, node.val});
            
            if (node.left != null) queue.offer(new Object[]{node.left, row + 1, col - 1});
            if (node.right != null) queue.offer(new Object[]{node.right, row + 1, col + 1});
        }
        
        for (List<int[]> nodes : columnMap.values()) {
            nodes.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<Integer> sortedColumn = new ArrayList<>();
            for (int[] node : nodes) sortedColumn.add(node[1]);
            result.add(sortedColumn);
        }
        
        return result;
    }

    
}