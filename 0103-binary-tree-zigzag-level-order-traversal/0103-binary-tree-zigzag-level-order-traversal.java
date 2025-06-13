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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            List<Integer> current = new LinkedList<>();
            int levelSize = q.size();

            for(int i=0; i<levelSize; i++){
                TreeNode t = q.poll();
                if(leftToRight){
                    current.add(t.val);
                }else{
                    current.add(0, t.val);
                }

                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            
                leftToRight = !leftToRight;
            result.add(current);
        }
        return result;
    }
}