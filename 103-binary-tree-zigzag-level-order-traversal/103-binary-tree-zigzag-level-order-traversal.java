class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        return levelOrderIterative(root);
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
        
        //out
        for(int i=0; i< out.size(); i++){
            if(i % 2 == 1){
                List<Integer> currList = out.get(i);
                reverseList(currList);
            }
        }
        
        return out;
    }
    
    private <T> void reverseList(List<T> list){
        // base case: the list is empty, or only one element is left
        if (list == null || list.size() <= 1) {
            return;
        }
 
        // remove the first element
        T value = list.remove(0);
 
        // recur for remaining items
        reverseList(list);
 
        // insert the top element back after recurse for remaining items
        list.add(value);
    }
}