class Solution {
    public int removeDuplicates(int[] nums) {
        
        // brute force
         return bruteForce(nums);
        //return 1;
        
    }
    
    private int bruteForce(int[] nums){
        
        if(nums == null) return 0;
        int len = nums.length;
        
        int  i=0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        
        return i+1;
        
    }
}