class Solution {
    int[] nums;
    Map<Integer, Integer> memoMap;
    public int rob(int[] nums) {
        this.nums = nums;
        
        // Top-Down Memoization
            //this.memoMap = new HashMap<>();
            //return topDownRecursive(nums.length-1);
        
        // Bottom-Up Tabulation
        return bottomUpTabulation(nums.length);
    }
    
    private int bottomUpTabulation(int n){
        
        if(n == 1){
            return nums[0];
        }else if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        int[] momoArray = new int[n];
        momoArray[0]=nums[0];
        momoArray[1]=Math.max(nums[0], nums[1]);
        
        for(int i=2; i< n; i++){
           momoArray[i] = Math.max(momoArray[i-1], momoArray[i-2]+nums[i]);     
        }
        
        return momoArray[n-1];
    }
    
    private int topDownRecursive(int i){
        if(i == 0){
            return nums[0];
        }else if(i == 1){
            return Math.max(nums[0], nums[1]);
        }else{
            
            if(!memoMap.containsKey(i)){
                int previousMax = topDownRecursive(i-1);
                int currMax = topDownRecursive(i-2)+nums[i];
                int maxMoney = Math.max(previousMax, currMax);
                memoMap.put(i, maxMoney);
            }
            
            return memoMap.get(i);
        }
    }
    
    
}