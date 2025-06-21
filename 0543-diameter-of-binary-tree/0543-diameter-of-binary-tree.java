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
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }
    public int calculateHeight(TreeNode current){
        if(current == null) return 0;

        int left = calculateHeight(current.left);
        int right = calculateHeight(current.right);

        int currentDia = left + right+1;

        diameter = Math.max(diameter, currentDia-1);

        return Math.max(left, right)+1;
    }
}