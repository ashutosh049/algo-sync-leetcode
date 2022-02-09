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
                if(valid(operand1, operand2, k, pairSet)){
                    pairSet.add(operand1 + operand2);
                }
            }
            
        }
        return pairSet.size();
    }
    
    /**
    * TC: 
    */
    private boolean valid(int op1, int op2, int k, Set<Integer> pairSet){
        
        // if(Math.abs(op1 - op2) == k){
        //     return !pairSet.contains(op1 + op2);
        // }
        // return false;
        return Math.abs(op1 - op2) == k;
        
    }
    
}