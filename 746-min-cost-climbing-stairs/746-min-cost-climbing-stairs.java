class Solution {
    Integer[] memo;
    int[] cost;
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        
        if(n ==2){
            return Math.min(cost[0], cost[1]);
        }
        
        this.cost = cost;
        this.memo = new Integer[n+1];
        
        memo[0] = 0;
        memo[1] = 0;
        
        return dp(n);
    }
    
    private int dp(int i){
        if(i ==1 || i== 0){
            return 0;
        }
        
        if(memo[i] == null){
            memo[i] = Math.min(dp(i-2)+cost[i-2], dp(i-1)+cost[i-1]); 
        }
        
        return memo[i];
    }
}