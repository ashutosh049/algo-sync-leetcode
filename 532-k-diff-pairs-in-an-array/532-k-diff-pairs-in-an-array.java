class Solution {
    public int findPairs(int[] nums, int k) {
    
    Set<Integer> pairMap = new HashSet<>();
        
        int len = nums.length;
        
        if(len == 1)
            return 0;
        
        for(int i=0; i<len; i++){
            
            int operand1 = nums[i];
            
            for(int j=i+1; j<len; j++){
                int operand2 = nums[j];
                if(valid(operand1, operand2, k, pairMap)){
                    //pairMap.add(Math.abs(operand1 + operand2));
                    pairMap.add(operand1 + operand2);
                }
            }
            
        }
        return pairMap.size();
    }
    
    private boolean valid(int op1, int op2, int k, Set<Integer> pairMap){
        
        if(Math.abs(op1 - op2) == k){
            return !pairMap.add(op1 + op2);
        }
        return false;
        
    }
    
}