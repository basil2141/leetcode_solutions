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
   private HashMap<Integer, Integer> map = new HashMap<>();
    private int index;
    public TreeNode buildTree( int[] inorder, int[] postorder) {
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        index = postorder.length-1;
        return helper(postorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] postorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        
        int rootVal = postorder[index--];
        TreeNode root = new TreeNode(rootVal);
        int i = map.get(rootVal);
       
        root.right = helper(postorder, i+1, inEnd); 
        root.left = helper(postorder, inStart, i-1);
        return root;
    }
}