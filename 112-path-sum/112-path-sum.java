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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum_iterative(root, targetSum);
    }
    
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

			// check for target-sum
            if(curr.left == null && curr.right == null && currSum == targetSum){
                hasPath = true;
                break;
            }

            
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