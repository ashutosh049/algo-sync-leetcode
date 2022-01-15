class Solution {
    int totalMoves;
    public int distributeCoins(TreeNode root) {
        this.totalMoves = 0;
        getCtbn(root);
        return totalMoves;
    }
    
    private int getCtbn(TreeNode root){
        if(root == null)
            return 0;
       
        int leftCtbn = getCtbn(root.left);
        int rightCtbn = getCtbn(root.right);
        
        totalMoves += Math.abs(leftCtbn) + Math.abs(rightCtbn);
        
        return root.val + leftCtbn + rightCtbn -1;
    }
}