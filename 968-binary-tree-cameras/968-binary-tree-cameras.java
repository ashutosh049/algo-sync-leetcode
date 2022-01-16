class Solution {
    int count;
    public int minCameraCover(TreeNode root) {
        this.count =0;
        if(dfs(root) == 0){
            this.count++;
        }
        return this.count;
    }
    
    /**
    * 1: Cam Not Required
    * 0: Cam Required
    * 2: Has Cam & Not Required
    */
    private int dfs(TreeNode root) {
        if(root == null){
            return 1;//NR
        }
        
        // if(isLeaf(root)){
        //     return true;
        // }
        
        int leftCamReq = dfs(root.left);
        int rightCamReq = dfs(root.right);
    
        
        if(leftCamReq == 0 || rightCamReq == 0){
            count++;
            return 2;                
        }else if(leftCamReq == 2 || rightCamReq == 2){
            return 1; 
        }else{
            return 0;
        }
        
    }
    
    private boolean isLeaf(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }
}