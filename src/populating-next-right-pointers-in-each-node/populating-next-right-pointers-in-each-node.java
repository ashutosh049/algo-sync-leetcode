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
        if (root == null) return root;
        recurseAndUpdate(root);
        return root;
    }
    
    private void recurseAndUpdate(Node root){
        
        if(root == null) return;
        
        Node curr = root;
        Node currNext = curr.next; 
        
        
        if(currNext != null){
            if(curr.right != null){
                curr.right.next = currNext.left;
            }
        }
        
        if(curr.left != null){
            curr.left.next = curr.right;
        }
        
        recurseAndUpdate(root.left);
        recurseAndUpdate(root.right);
        
    }
}