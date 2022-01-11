class Solution {
    public TreeNode invertTree(TreeNode root) {
        //dfs(root);
        //return root;
        
        return bfs(root);
    }
    
    private TreeNode bfs(TreeNode root){
        
        if (root == null) return null;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        
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