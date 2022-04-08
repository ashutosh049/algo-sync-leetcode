class Solution {
    public int reverse(int num) {
        
        int rev = 0;
        
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        while(num != 0){
            int pop = num % 10;
            
            if(rev > max/10 || (rev == max/10 && pop > 7)){
                return 0;
            }
            
            if(rev < min/10 || (rev == min/10 && pop < -8)){
                return 0;
            }
            
            rev *= 10;
            rev += pop;
            
            num /= 10;
        }
        
        return rev;
    }
}