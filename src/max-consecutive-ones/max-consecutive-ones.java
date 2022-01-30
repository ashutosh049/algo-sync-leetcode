class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        if(nums.length == 1 && nums[0] ==1)
            return 1;
        else{
            
            int maxCount = 0;
            int currCount = 0;
            
            //[1,1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,1]
            for(int i=0; i<nums.length; i++){
                if(nums[i] == 1){
                    currCount++;
                    //maxCount = Math.max(maxCount, currCount);// extra overhead of updating on all 1
                }else{
                    maxCount = Math.max(maxCount, currCount);
                    currCount = 0;
                }
            }
            
            maxCount = Math.max(maxCount, currCount);
            
            return maxCount;
        }
        
    }
}