class Solution {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    
    private void dfs(TreeNode root){
        
        if(root == null){
            return;
        }
        
        TreeNode lVal = root.left;
        root.left = root.right;
        root.right = lVal;
        
        dfs(root.left);
        dfs(root.right);
        
    }
}