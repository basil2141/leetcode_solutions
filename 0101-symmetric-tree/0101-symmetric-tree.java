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
import java.util.Stack;
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.right);
        stack.push(root.left);
        while(!stack.isEmpty()){
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if(n1==null && n2==null) continue;
            if(n1==null || n2==null || n1.val !=n2.val) return false;

            stack.push(n2.right);
            stack.push(n1.left);
            stack.push(n2.left);
            stack.push(n1.right);
        }
        return true;
        
    }
}