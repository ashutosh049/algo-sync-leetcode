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
    int paths;
    int targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        this.paths = 0;
        this.targetSum = targetSum;
        //dfs(root, 0);
        dfs(root);
        return paths;
    }
    
    private void dfs(TreeNode root) {
        if(root == null) return;
        
        recurse(root, 0);
        dfs(root.left);
        dfs(root.right);
        
    }
    
    private void recurse(TreeNode root, int parentSum) {
        if(root == null) return;

        if(parentSum + root.val == targetSum){
            paths++;
        }
        
        recurse(root.left, parentSum+root.val);
        recurse(root.right, parentSum+root.val);
        
    }
    
    
}