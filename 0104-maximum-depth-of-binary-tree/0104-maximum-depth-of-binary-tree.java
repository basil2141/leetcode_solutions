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
    int depth = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return depth;
    }
    public int helper(TreeNode root){
if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int d = 1 + Math.max(left, right);
        depth = Math.max(depth, d);
        return d;
    }
}