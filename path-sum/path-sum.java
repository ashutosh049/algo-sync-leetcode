class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null){
            return false;
        }
        //return hasPathSum_recursive(root, 0, targetSum);
        return hasPathSum_iterative(root, targetSum);
    }
    
    /** 
    * Recursive path sum
    */
    private boolean hasPathSum_recursive(TreeNode root, int cs, int ts){
        if(root == null) return cs == ts;
        
        return hasPathSum_recursive(root.left, cs+root.val, ts) ||
            hasPathSum_recursive(root.right, cs+root.val, ts);
    }

  /**
   * Iterative path sum. Intuition: Proceed in a classic post-order iterative fashion, with 2 things
   * in mind:
   * <p>
   * 1. Keep a currSum variable which will have the total sum up to curr node
   * <p>
   * 2. On each pop-operation/climb-up (processing of a node), and since we know that we have
   * already checked if this node  was a leaf node and if the sum till this node is equal to target,
   * we reduce it's value from `currSum` which we added while traversing downwards.
   * <p>
   * Time: O(n)
   * <p>
   * Space: O(n)
   */
    private boolean hasPathSum_iterative(TreeNode root, int targetSum){
        
        boolean hasPath = false;
        
        if(root == null)
            return hasPath;
        
        TreeNode curr = root;
        TreeNode pre = null;
        int currSum = 0;
        Stack<TreeNode> s = new Stack();
        
        while(curr != null || !s.isEmpty()){
            
            while(curr != null){
                currSum += curr.val;
                s.push(curr);
                curr = curr.left;
            }
            
            curr = s.peek();

            if(curr.left == null && curr.right == null && currSum == targetSum){
                hasPath = true;
                break;
            }
            
            // If right ST is null or already processed(equal to pre)
            // then process curr
            if(curr.right == null || curr.right == pre){
                curr = s.pop();
                currSum -= curr.val;
                pre = curr;
                curr = null;   
            }else {
                curr = curr.right;
            }
            
            
        }
        
        return hasPath;
    }
    
    
}