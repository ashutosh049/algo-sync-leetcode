class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> levelOrder =  levelOrderIterative(root);
        
        // Reverse the alternate levels of nodes
        if(levelOrder != null && levelOrder.size() >= 2){
            for(int i=0; i< levelOrder.size(); i++){
                if(i % 2 == 1){
                    reverseList(levelOrder.get(i));
                }
            }            
        }
        
        return levelOrder;
    }
    
    private List<List<Integer>> levelOrderIterative(final TreeNode root){
        
        List<List<Integer>> out = new ArrayList<>();
        
        if(root == null){
            return out;
        }
        
        TreeNode curr = root;
        Deque<TreeNode> deq = new ArrayDeque<>();
        deq.add(curr);
        int level = 0;
        
        while(!deq.isEmpty()){
            
            out.add(new ArrayList<>());
            int s = deq.size();
            
            for(int i=0; i < s; i++){
                
                TreeNode node = deq.remove();
                out.get(level).add(node.val);

                if(node.left != null){
                    deq.add(node.left);
                }

                if(node.right != null){
                    deq.add(node.right);
                }                    

                            
            }
                        
            level++;
            
        }
        
        return out;
    }
    
    /**
    * Recursive in-place reversal of a List
    */
    private <T> void reverseList(List<T> list){
        if (list == null || list.size() <= 1) {
            return;
        }
        T value = list.remove(0);
        reverseList(list); 
        list.add(value);
    }
}