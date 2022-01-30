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
    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        
        boolean isSame = false;
        
        if(!ifSame(t1, t2))
            return isSame;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(t1);
        q.offer(t2);
        
        while(!q.isEmpty()){
            
            TreeNode t1Child = q.poll();
            TreeNode t2Child = q.poll();
            
            
            if(!ifSame(t1Child, t2Child))
                return false;
            
            // Remember, if both t1child and t2child are null, they are same.
            // To avoid NPE before fetching child
            if(t1Child != null && t2Child != null){                
                q.offer(t1Child.left);
                q.offer(t2Child.left);

                q.offer(t1Child.right);
                q.offer(t2Child.right);
            }
            
        }
        
        return true;
        
    }
    
    private boolean ifSame(TreeNode t1, TreeNode t2){
        return (t1 == null && t2 == null) ||
            (t1 != null && t2 != null && t1.val==t2.val);
            
    }
}