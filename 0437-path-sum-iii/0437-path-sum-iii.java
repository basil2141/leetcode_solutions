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
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> currentPath = new ArrayList<>();
        return countPath(root, targetSum, currentPath);
    }
    public static int countPath(TreeNode current, int S, List<Integer> currentPath){
        if(current == null ) return 0;

        int count =0;
        long sum = 0;
        currentPath.add((long)current.val);

        ListIterator<Integer> iterator = currentPath.listIterator(currentPath.size());

        while(iterator.hasPrevious()){
            sum += iterator.previous();
            if(sum == S) count++;
        }

        count += countPath(current.left, S, currentPath);
        count += countPath(current.right, S, currentPath);

        currentPath.remove(currentPath.size()-1);

        return count;
    }
}