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
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            double sum =0;
            for(int i=0; i<levelSize; i++){
                TreeNode t = q.poll();
                sum += t.val;
                
                if(t.left !=null) q.offer(t.left);
                if(t.right !=null) q.offer(t.right);
            }
            result.add(sum/(double)levelSize);
        }
        return result;

    }
}