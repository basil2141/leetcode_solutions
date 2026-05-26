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
    public TreeNode bstToGst(TreeNode root) {
        int[] sum = new int[1];
        inOrder(root, sum);
        return root;
    }
    public void inOrder(TreeNode root, int[] sum){
        if(root == null) return;

        inOrder(root.right, sum);
        int temp = root.val;
        root.val += sum[0];
        sum[0] += temp;

        inOrder(root.left, sum);
    }
}