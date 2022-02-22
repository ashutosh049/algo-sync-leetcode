class Solution {
    int[] nums;
    int n;
    Boolean[] memo;
    public boolean canJump(int[] nums) {
        
        if(nums.length == 1){
            return true;
        }
        
        if(nums[0] == 0){
            return false;
        }
        
        this.nums=  nums;
        this.n = nums.length;
        this.memo = new Boolean[n];
        
        return dp(0);        
    }
    
    
    boolean dp(int i){
        
        if(i == n-1){
            return true;
        }
        
        if(memo[i] == null){
            boolean reachable = false;
            
            for(int k=1; k < n && k <= nums[i]; k++){
                if(dp(i+k)){
                    reachable = true;
                    break;
                }
            }   
            
            memo[i] = reachable;
        }
        
        
        return memo[i];
        
    }
}