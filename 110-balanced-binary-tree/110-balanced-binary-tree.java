class Solution {
     Boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }
    
    private int dfs(TreeNode node) {
        if (!balanced || node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        if (Math.abs(left - right) > 1) {
            balanced = false;
        }
        return Math.max(left, right) + 1;
    }
}