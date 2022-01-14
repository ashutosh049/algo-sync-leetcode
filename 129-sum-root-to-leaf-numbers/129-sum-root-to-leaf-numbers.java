class Solution {
    
    public int sumNumbers(final TreeNode root) {
        
        //return sumNumbers_postOrder_iterative(root);
        return sumNumbers_preOrder_recursive(root, 0);
    }
    
    public int sumNumbers_postOrder_iterative(final TreeNode root) {
        
        int totalSum =0;        
        StringBuilder sb = new StringBuilder();
        
        TreeNode curr = root;
        TreeNode prev = root;
        
        Deque<TreeNode> deq = new ArrayDeque<>();
        
        while(curr != null || !deq.isEmpty()){
            
            if(curr != null){
                sb.append(curr.val);
                deq.push(curr);
                curr = curr.left;
            }else{
                curr = deq.peek();
                
                if(isLeaf(curr)){
                    totalSum += Integer.valueOf(sb.toString());
                }
                
                if(curr.right == null || curr.right == prev){
                    curr  = deq.pop();
                    sb.deleteCharAt(sb.length()-1);
                    prev = curr;
                    curr = null;
                }else{
                    curr = curr.right;
                }
                
            }
            
        }
        return totalSum;
    }
    
    public int sumNumbers_preOrder_recursive(final TreeNode root, int preSum) {
        
        if(root == null){
            return 0;
        }
            
        int currSum =  root.val + (preSum *10);

        if(isLeaf(root)){
            return currSum;
        }

        int leftSum = sumNumbers_preOrder_recursive(root.left, currSum);
        int rightSum = sumNumbers_preOrder_recursive(root.right, currSum);

        return leftSum + rightSum;
        
    }
    
    private boolean isLeaf(TreeNode node){
        if(node != null && node.left == null && node.right == null)
            return true;
        
        return false;
    }
}