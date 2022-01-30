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
class BSTIterator {

    private TreeNode root;
    private int index;
    private int[] inorder;
    private List<Integer> iList;
    private int i;
    
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.index = 0;
        init(this.root);
    }
    
    public int next() {
        return inorder[index++];
    }
    
    public boolean hasNext() {
        return (index+1) <= inorder.length;
    }
    
    private void init(TreeNode root){
        this.i = 0;
        this.iList = new ArrayList<>();
        inorderRecursive(root);
        inorder = new int[iList.size()];
        for(int e: iList){
            inorder[i++] = e; 
        }
    }
    
    //3, 7, 9, 15, 20
    private void inorderRecursive(TreeNode root){
        if(root == null) return;
        
        inorderRecursive(root.left);
        
        iList.add(root.val);
        
        inorderRecursive(root.right);
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */