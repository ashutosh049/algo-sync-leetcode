class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return isValid(root, null, null);
    }
    
    private boolean isValid(TreeNode root, Integer low, Integer high){
        if(root == null){
            return true;
        }
        
        if(low != null && root.val <= low){
            return false;
        }
        
        if(high !=null && root.val >= high){
            return false;
        }
        
        return isValid(root.left, low, root.val) && isValid(root.right, root.val, high);
        
    }
}