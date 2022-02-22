class Solution {
    int[] nums;
    int n;
    Boolean[] memo;
    public boolean canJump(int[] nums) {
        
        this.nums = nums;
        this.n = nums.length;
        
        if(n == 1){
            return true;
        }
        
        if(nums[0] ==0)
            return false;
        
        this.memo = new Boolean[n];
        
        return dp(0);
        
    }
    
    private boolean dp(int i){
        
        if( i == n-1){
            return true;
        }
        
        if(nums[i] == 0){
            return false;
        }
        
        if(memo[i] == null){
            boolean recheable = false;
            for(int k = 1; k <= nums[i] && k<= n-1; k++){
                if(dp(i+k)){
                    recheable = true;
                    break;
                }
            }
            
            memo[i] = recheable;    
            
        }
        return memo[i];
        
    }
}