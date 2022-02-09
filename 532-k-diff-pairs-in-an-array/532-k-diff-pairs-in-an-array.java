class Solution {
    public int findPairs(int[] nums, int k) {
    
        Set<Integer> pairSet = new HashSet<>();
        
        int len = nums.length;
        
        if(len == 1)
            return 0;
        
        for(int i=0; i<len; i++){
            
            int operand1 = nums[i];
            
            for(int j=i+1; j<len; j++){
                int operand2 = nums[j];
                if(Math.abs(operand1 - operand2) == k){
                    pairSet.add(operand1 + operand2);
                }
            }
            
        }
        return pairSet.size();
    }
    
}