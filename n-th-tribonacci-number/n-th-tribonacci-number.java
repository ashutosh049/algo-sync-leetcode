class Solution {
    public int tribonacci(int n) {
        
        if(n == 0 ){
            return 0;
        } else if(n == 1 || n == 2){
            return 1;
        }
        
        int p1 = 1;
        int p2 = 1;
        int p3 = 0;
        
        int cur = 0;
        int i=3;
        
        while(i++ <= n){
            
            cur = p1 + p2 + p3;
            
            p3 = p2;
            p2 = p1;
            p1 = cur;
            
        }
        
        return cur;
    }
}