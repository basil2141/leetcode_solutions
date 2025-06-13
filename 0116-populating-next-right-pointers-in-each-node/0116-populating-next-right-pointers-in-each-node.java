/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Node previous = null;
            int levelSize = q.size();

            for(int i=0; i<levelSize; i++){
                Node current = q.poll();

                if(previous != null) 
                    previous.next = current;
                previous = current;

                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);
            }
        }
        return root;    
    }
}