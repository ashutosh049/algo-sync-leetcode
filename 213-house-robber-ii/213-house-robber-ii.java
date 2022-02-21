class Solution {
    int[] nums;
    int n;
    Integer[] memo;
    public int rob(int[] nums) {
        
        this.nums = nums;
        this.n = nums.length;
        
        if(n == 1){
            return nums[0];
        }else if(n == 2){
            return Math.max(nums[0], nums[1]);
        }else if(n == 3){
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        
        // Memo array for 1st calculation max1 from index 0 to n-2
        this.memo = new Integer[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        int max1 = dp(0, n-2);

        // Reset the memo array for 2nd calculation max2 from index 1 to n-1
        this.memo = new Integer[n];
        memo[1] = nums[1];
        memo[2] = Math.max(nums[1], nums[2]);
        int max2 = dp(1, n-1);
        
        
        return Math.max(max1, max2);
        
    }
    
    private int dp(int start, int i){
        if(i== start || i== start+1){
            return memo[i];
        }
        
        if(memo[i] == null){
            memo[i] = Math.max(dp(start, i-2)+ nums[i], dp(start, i-1));
        }
        
        return memo[i];
    }

}