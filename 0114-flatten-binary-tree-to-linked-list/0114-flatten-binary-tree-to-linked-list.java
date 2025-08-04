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
    public void flatten(TreeNode root) {
        dfs(root);
    }
    public TreeNode dfs(TreeNode node){
        if(node == null) return null;

        TreeNode leftTail = dfs(node.left);
        TreeNode rightTail = dfs(node.right);

        if(node.left != null){
            leftTail.right = node.right;

            node.right = node.left;

            node.left = null;
        }

        return rightTail != null ? rightTail : (leftTail != null ? leftTail : node);
    }
}