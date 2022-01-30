class Solution {
    int count;
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        this.count = 0;
        this.target = target;
        recurse(nums, 0, 0);
        return this.count;
    }
    
    private void recurse(int[] nums, int i, int expr){
        
        if(i == nums.length){
            if(expr == this.target){
                this.count++;
            }
            return;
        }
            
        recurse(nums, i+1, (expr+nums[i]));
        recurse(nums, i+1, (expr-nums[i]));
        
    }
}