class Solution {
    int[] memo;
    public int fib(int n) {
        this.memo = new int[n+1];
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return dp(n);
    }
    
    private int dp(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        
        if(memo[n] == 0){
            memo[n] = dp(n-1) + dp(n-2);
        }
        
        return memo[n];
    }
}