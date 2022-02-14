class Solution {
    
    private int[][] memo;
    private int[] nums, multipliers;
    private int n, m;
    
    public int maximumScore(int[] nums, int[] multipliers) {
        this.n = nums.length;
        this.m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        this.memo = new int[m][m];
        return dp(0, 0, n-1);
    }
    
    private int dp(int i, int left, int right) {
        if (i == m) {
            return 0; // Base case
        }

        int mult = multipliers[i];
            
        if (memo[i][left] == 0) {
            memo[i][left] = Math.max(mult * nums[left] + dp(i + 1, left + 1, right), 
                                     mult * nums[right] + dp(i + 1, left, right-1));
        }

        return memo[i][left];
    }
    
    
}