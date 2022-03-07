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
    * null: Cam Not Required
    * true: Cam Required
    * false: Has Cam & Not Required
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
        }
        
        return true;
        
        
    }
    
}