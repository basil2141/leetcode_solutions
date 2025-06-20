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
    public int sumNumbers(TreeNode root) {
        return findNumbers(root, 0);
    }
    public static int findNumbers(TreeNode current, int number){
        if(current == null) return 0;

        number = number*10 + current.val;

        if(current.left == null && current.right == null) return number;

        return findNumbers(current.left, number) + findNumbers(current.right, number);
    }
}