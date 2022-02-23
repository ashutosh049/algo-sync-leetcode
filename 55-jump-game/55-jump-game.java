class Solution {
    int[] nums;
    int n;
    public boolean canJump(int[] nums) {
        
        if(nums.length == 1){
            return true;
        }
        
        this.nums = nums;
        this.n = nums.length;
        
        if(nums[0] == 0){
            return false;
        }

        //boolean reachable = false;
        int i=1;

        while(i < n-1){
            int prev = nums[i-1];
            int curr = nums[i];
            if(prev -1 > curr){
                nums[i] = prev -1;
            }
            if(nums[i] ==0){
                break;
            }
            i++;
        }

        return i == n-1;
        
    }
    
}