class Solution {
    public boolean isSameAfterReversals(int num) {
        
        if(num == 0){
            return true;
        }
        
        if(num % 10 == 0){
            return false;
        }
        
        return num == reverse(reverse(num));
        
    }
    
    private int reverse(int num){
        int rev = 0;
        int min  = Integer.MIN_VALUE;
        int max  = Integer.MAX_VALUE;
        
        while(num != 0){
            
            int pop = num % 10;
            
            /**
                // We do not need this validation, as 0 <= num <= 106

                if(rev > max/10 || (rev == max/10 && pop > 7)){
                    return 0;
                }
                if(rev < min/10 || (rev == min/10 && pop < -8)){
                    return 0;
                }
            */
            
            rev *= 10;
            rev += pop;
            num /= 10;
            
        }
        
        return rev;
    }
}