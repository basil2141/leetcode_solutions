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
    private int sum = 0;
    public int maxPathSum(TreeNode root) {
        this.sum = Integer.MIN_VALUE;
        calculateSum(root);
        return sum;
        
    }
    public int calculateSum(TreeNode current){
        if(current == null) return 0;

        int left = calculateSum(current.left);
        int right = calculateSum(current.right);

        // rejecting negative branch

        left = Math.max(left, 0);
        right = Math.max(right, 0);

        int localSum = left + right + current.val;

        sum = Math.max(sum, localSum);

        return Math.max(left, right) + current.val;


    }
}