class Solution {
    public int sumNumbers(final TreeNode root) {
        
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
                    Integer currSum = Integer.valueOf(sb.toString());
                    totalSum += currSum;
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
    
    private boolean isLeaf(TreeNode node){
        if(node != null && node.left == null && node.right == null)
            return true;
        
        return false;
    }
}