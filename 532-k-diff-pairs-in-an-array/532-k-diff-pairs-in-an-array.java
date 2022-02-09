class Solution {
    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);
        
        int len = nums.length;
        
        if(len ==1)
            return 0;
        
        int uniquePairCount = 0;
        
        
        for(int i=0; i<len; i++){
            
            if(i  > 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            for(int j=i+1; j<len; j++){
                
                if(j  > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                
                if(Math.abs(nums[i]-nums[j]) == k){
                    uniquePairCount++;
                }
            }
            
        }
        
        return uniquePairCount;

    }
    
}