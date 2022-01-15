class Solution {
    int totalMoves = 0;
    public int distributeCoins(TreeNode root) {
        getCtbn(root);
        return totalMoves;
    }
    
    private int getCtbn(TreeNode root){
        if(root == null)
            return 0;
       
        int leftCtbn = getCtbn(root.left);
        int rightCtbn = getCtbn(root.right);
        
        root.val += leftCtbn + rightCtbn;
        
        totalMoves += Math.abs(leftCtbn) + Math.abs(rightCtbn);
        
        return root.val -1;
    }
}