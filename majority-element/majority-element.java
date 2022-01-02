class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        
        if(nums.length ==1){
            return nums[0];
        }
        
        int maxCount = 0;
        int majorityElm = nums[0];
        for(int i: nums){
            Integer c = map.get(i); 
            
            if(c == null){
                c = 0;    
            }
            c++;
            if(maxCount < c){
                maxCount = c;
                majorityElm = i;
            }
            
            map.put(i, c);
        }
        
        return majorityElm;
        
    }
}