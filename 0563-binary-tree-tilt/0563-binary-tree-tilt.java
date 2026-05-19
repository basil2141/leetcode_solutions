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
    public int findTilt(TreeNode root) {
        Pair p = recursion(root);
        return p.ston;
    }
    public Pair recursion(TreeNode root){
        if(root == null){
            return new Pair(0, 0);
        }
        Pair left = recursion(root.left);
        Pair right = recursion(root.right);

        int tilt = Math.abs(left.son - right.son);
        int son = left.son + right.son + root.val;
        int ston = tilt + left.ston + right.ston;
        return new Pair(son, ston);
    }
}
class Pair{
    int son, ston;
    public Pair(int son, int ston){
        this.son = son;

        this.ston = ston;
    }
}