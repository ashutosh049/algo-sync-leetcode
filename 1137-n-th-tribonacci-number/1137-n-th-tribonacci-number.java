class Solution {
    public int tribonacci(int n) {
        
        if(n == 0 ){
            return 0;
        } else if(n == 1 || n == 2){
            return 1;
        }
        
        int prev1 = 1;
        int prev2 = 1;
        int prev3 = 0;
        
        int i=3;
        
        while(i++ <= n){
            
            int cur = prev1 + prev2 + prev3;
            
            prev3 = prev2;
            prev2 = prev1;
            prev1 = cur;
            
        }
        
        return prev1;
    }
}