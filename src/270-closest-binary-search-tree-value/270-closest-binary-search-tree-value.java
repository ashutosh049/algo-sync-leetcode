class Solution {
    int closestVal;
    double minDiff;
    public int closestValue(TreeNode root, double target) {
       this.closestVal = Integer.MAX_VALUE;
       this.minDiff = Double.MAX_VALUE;
        dfsClosest(root, target);
        return this.closestVal;
    }
    private void dfsClosest(TreeNode root, double target){
        
        if(root == null){
            return;
        }
        
        double currDiff = Math.abs(target - (double)root.val);
        if(currDiff < minDiff){
            minDiff = currDiff;
            closestVal = root.val;
        }
        
        if(target == (double)root.val){
            closestVal = root.val;
            return;
        }else if(target < (double)root.val){
            dfsClosest(root.left, target);
        }else{
            dfsClosest(root.right, target);
        }
        
        //return closestVal;
        
    }
}