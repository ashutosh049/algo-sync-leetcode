class Solution {
    int[] nums;
    int n;
    Integer[] memo;
    public boolean canJump(int[] nums) {
        
        this.nums = nums;
        this.n = nums.length;
        
        if(n == 1){
            return true;
        }
        
        if(nums[0] ==0)
            return false;
        
        this.memo = new Integer[n];
        
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
            for(int k = 1; k <= nums[i]; k++){
                if(dp(i+k)){
                    recheable = true;
                    break;
                }
            }
            
            if(recheable){
                memo[i] = 1;    
            }else{
                memo[i] = 0;
            }
            
        }
        return memo[i] == 0 ? false : true;
        
    }
}