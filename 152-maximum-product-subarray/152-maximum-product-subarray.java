class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 1;
        
        for(int i=0; i<nums.length; i++) {
            cur*=nums[i];
            
            max = Math.max(max, cur);
            
            if(cur == 0) {
                cur = 1;
            }
        }
        cur = 1;
        for(int i=nums.length-1; i >= 0; i--) {
            cur*=nums[i];
            
            max = Math.max(max, cur);
            
            if(cur == 0) {
                cur = 1;
            }
        }
        return max;
    }
}