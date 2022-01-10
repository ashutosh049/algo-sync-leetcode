class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
      public boolean validate(TreeNode root, Integer low, Integer high) {
        
        if (root == null) {
            return true;
        }
        
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
}