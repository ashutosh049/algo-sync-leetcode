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
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        
        TreeNode curr = root;
        TreeNode pre = null;
        List<Integer> currSumList = new ArrayList<>();
        int curSum = 0;
        Stack<TreeNode> s= new Stack();
        
        while(curr != null || !s.empty()){
            if(curr != null){
                currSumList.add(curr.val);
                curSum += curr.val;
                s.push(curr);
                curr = curr.left;
            }else{
                curr  =  s.peek();
                
                if(curr.left == null && curr.right == null && curSum == targetSum){
                    res.add(currSumList.stream().collect(Collectors.toList()));
                }
                
                if(curr.right == null || curr.right == pre){
                    curr = s.pop();
                    
                    currSumList.remove(currSumList.size()-1);
                    curSum -= curr.val;
                    
                    pre = curr;
                    curr = null;
                }else{
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}