import java.util.logging.Level;
import java.util.logging.Logger;
class Solution {

    List<Integer> resultList = new ArrayList<>();
          
    public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root == null){
            return new ArrayList<>();
        }
    
        
        resultList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        
        return resultList;
       
    }

}