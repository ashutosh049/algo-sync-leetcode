class Solution {
    public int subsetXORSum(int[] nums) {
      return recurse(nums,0,0);
    }
    
    public int recurse(int nums[],int i, int xorTotal){
        if(i == nums.length){
            return xorTotal;    
        }
        
        return recurse(nums, i+1, xorTotal^nums[i]) + recurse(nums, i+1, xorTotal);
    }
    
    
    
}