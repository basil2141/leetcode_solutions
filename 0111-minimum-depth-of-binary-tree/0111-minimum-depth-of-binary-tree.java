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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int minDepth=0;

        while(!q.isEmpty()){
            minDepth++;
            int levelSize = q.size();

            for(int i=0; i<levelSize; i++){
                TreeNode t = q.poll();

                if(t.left == null && t.right == null) return minDepth++;

                if(t.left != null) q.offer(t.left);

                if(t.right != null) q.offer(t.right);
            }
        }
        return minDepth;
    }
}