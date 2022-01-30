class Solution {
    int count;
    public int minCameraCover(TreeNode root) {
        this.count =0;
        Boolean camReq = dfs(root);
        if(camReq != null && camReq){
            this.count++;
        }
        return this.count;
    }
    
    /**
    * 1: Cam Not Required: null
    * 0: Cam Required: true
    * 2: Has Cam & Not Required: false
    */
    private Boolean dfs(TreeNode root) {
        if(root == null){
            return null;
        }
                
        Boolean leftCamReq = dfs(root.left);
        Boolean rightCamReq = dfs(root.right);
    
        
        if((leftCamReq!= null && leftCamReq) || (rightCamReq != null && rightCamReq)){
            count++;
            return false;                
        }else if((leftCamReq!= null && !leftCamReq) || (rightCamReq != null && !rightCamReq)){
            return null; 
        }else{
            return true;
        }
        
    }
    
    private boolean isLeaf(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }
}