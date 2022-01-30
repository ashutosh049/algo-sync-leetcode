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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> out = new ArrayList<>();
        
        if(root == null)
            return out;
        
        Stack<TreeNode> nodeStack = new Stack();
        TreeNode curr = root;
        TreeNode pre = null;
        StringBuilder sb = new StringBuilder();
        
        while(curr != null || !nodeStack.isEmpty()){
            if(curr != null){
                if(sb.length() > 0){
                    sb.append("->");
                }
                sb.append(curr.val);
                nodeStack.push(curr);
                curr = curr.left;
            }else{
                curr = nodeStack.peek();
                
                // if leaf node
                if(curr.left == null && curr.right == null){
                    out.add(sb.toString());
                }
                
                if(curr.right == null || curr.right == pre){
                    curr = nodeStack.pop();
                    
                    int currAppendedStringLength = String.valueOf(curr.val).length();
                    

                    if(sb.lastIndexOf("->") > -1){
                        currAppendedStringLength +=2 ;
                    }
                        sb.delete(sb.length()-currAppendedStringLength, sb.length());
                    
                    pre = curr;
                    curr = null;
                }else{
                    curr= curr.right;
                }
            }
        }
        return out;
    }
}