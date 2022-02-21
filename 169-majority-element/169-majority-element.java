class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        
        if(nums.length ==1){
            return nums[0];
        }
        
        int maxCount = 1;
        int majorityElm = nums[0];
        
        for(int currElm: nums){
            Integer currElmCount = map.getOrDefault(currElm, 0)+1; 
            
            if(maxCount < currElmCount){
                maxCount = currElmCount;
                majorityElm = currElm;
            }
            
            map.put(currElm, currElmCount);
        }
        
        return majorityElm;
        
    }
}