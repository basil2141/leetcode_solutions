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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode current=null, prev = null;

        while(!q.isEmpty()){
            int levelSize = q.size();

            for(int i=0; i<levelSize; i++){
                TreeNode t = q.poll();
                if(i== levelSize-1) result.add(t.val);

                if(t.left != null) q.offer(t.left);
                if(t.right !=null) q.offer(t.right);
            }
        }

        return result;
    }
}