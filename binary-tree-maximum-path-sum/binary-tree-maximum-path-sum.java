class Solution {
  int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    //recurse(root);
    getMaxPathSum(root);
    return maxSum;
  }
    
    int recurse(TreeNode root){
        
        if(root == null) return 0;
        
        int leftMax = recurse(root.left);
        int rightMax = recurse(root.right);
        
        int maxChildren =  Math.max(leftMax, rightMax);
        
        int maxWithRoot = Math.max(root.val, (root.val + maxChildren));
        
        int maxNode = Math.max(maxWithRoot, root.val + leftMax + rightMax);
        
        maxSum = Math.max(maxSum, maxNode);
        
        return maxWithRoot;
        
    }
    
    // Enhanced version of our logic
	private int getMaxPathSum(TreeNode root) {
        
        if (root == null) return 0;
        
        int leftMax = Math.max(0, getMaxPathSum(root.left)); // Take 0 instead of a negative left sum
        int rightMax = Math.max(0, getMaxPathSum(root.right)); // Take 0 instead of a negative right sum
        
        maxSum = Math.max(maxSum, (leftMax + rightMax + root.val));
        
        return Math.max(leftMax, rightMax) + root.val;
    }
    
}