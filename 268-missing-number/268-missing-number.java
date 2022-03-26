class Solution {
    public int missingNumber(int[] nums) {
        
        int len = nums.length;
        
        int totalSum = (len*(1+len))/2;
        
        int currSum = 0;
        for(int num: nums){
            currSum += num;
        }
        
        return totalSum - currSum;
    }
}