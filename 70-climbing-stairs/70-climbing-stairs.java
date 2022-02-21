class Solution {
    int n;
    int[] memo;
    public int climbStairs(int n) {
        
        this.n = n;
        this.memo = new int[n+1];
        
        if(n <= 2){
            return n;
        }
        Arrays.fill(memo, -1);
        
        
        memo[0]=0;
        memo[1]=1;
        memo[2]=2;
        
        return climb(n);
        
    }
    
    private int climb(int i){
        if(i > n){
            return 0;
        }
        // if(i == n){
        //     return 1;
        // }
        
        // Check if we haven't evaluated ith stair
        if(memo[i] == -1){
            memo[i] = climb(i-1) + climb(i-2);
        }
        
        return memo[i];
    }
}