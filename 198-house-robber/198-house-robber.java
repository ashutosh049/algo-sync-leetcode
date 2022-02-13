class Solution {
    int[] nums;
    Map<Integer, Integer> memoMap;
    public int rob(int[] nums) {
        this.nums = nums;
        this.memoMap = new HashMap<>();
        return recur(nums.length-1);
    }
    
    private int recur(int i){
        if(i == 0){
            return nums[0];
        }else if(i == 1){
            return Math.max(nums[0], nums[1]);
        }else{
            
            if(!memoMap.containsKey(i)){
                int previousMax = recur(i-1);
                int currMax = recur(i-2)+nums[i];
                int maxMoney = Math.max(previousMax, currMax);
                memoMap.put(i, maxMoney);
            }
            
            return memoMap.get(i);
        }
    }
}