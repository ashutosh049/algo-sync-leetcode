class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }
        
        Arrays.sort(nums);
        int maxElement = nums[nums.length-1];
        
        int[] freq = new int[maxElement+1];
        int[] maxVal = new int[maxElement+1];
        
        for(int i: nums){
            freq[i]++;
        }
        
        maxVal[0] = 0;
        maxVal[1] = freq[1] * 1;
        
        for(int i=2; i < freq.length; i++){
            
            int prevMax = maxVal[i-1];
            int currMax = maxVal[i-2]+ (freq[i] * i);
            int totalPoints = Math.max(prevMax, currMax); 
            maxVal[i] = totalPoints; 
            
        }
        return maxVal[maxElement];
    }
        
}