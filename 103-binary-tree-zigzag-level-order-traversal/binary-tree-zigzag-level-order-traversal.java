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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result  = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for(int i = 0 ; i <levelSize; i++){
                TreeNode node = queue.poll();
            
            if(leftToRight){
                levelList.addLast(node.val);
            }else{
                levelList.addFirst(node.val);
            }
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        
            result.add(levelList);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
