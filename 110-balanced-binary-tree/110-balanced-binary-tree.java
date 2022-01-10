class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    
    private int getHeight(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
        int heightLeftSt = getHeight(root.left);
        int heightRightSt = getHeight(root.right);
    
        if(heightLeftSt == -1 || heightRightSt == -1 || Math.abs(heightLeftSt - heightRightSt) > 1){
            return -1;
        }

        return Math.max(heightLeftSt, heightRightSt) +1;
                 
    }
}