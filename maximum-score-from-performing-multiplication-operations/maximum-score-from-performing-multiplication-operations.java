class Solution {
    private Integer[][] memo;
    private Integer[] resArr;
    private int[] nums, multipliers;
    private int n, m;
    
    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        this.memo = new Integer[m][m];
        this.resArr = new Integer[m];
        
    
        //return dp(0, 0);
        int left = 0;
        int right = n-1;
        return dp(0, left, right);
    }
    
    private int dp(int i, int left, int right) {
        if (i == m) {
            return 0; // Base case
        }

        int mult = multipliers[i];
        
        //if(resArr[i] == null){
        if(memo[i][left] == null){
            int leftRes = (mult * nums[left]) + dp(i+1, left+1, right);
            int rightRes = (mult * nums[right]) + dp(i+1, left, right-1);
            //resArr[i] = Math.max(leftRes, rightRes);
            memo[i][left] = Math.max(leftRes, rightRes);
            
        }

        //return resArr[i];
        return memo[i][left];
    }
    
}