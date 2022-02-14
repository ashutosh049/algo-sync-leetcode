class Solution {
    public int reverse(int x) {
        
        long reversed = 0;
        int mul = 10;
        boolean isNegetive = false;
        
        if(x == 0){
            return 0;
        }else if(x < 0){
            isNegetive = true;
        }
        
        x = Math.abs(x);
        
        while(x >= 1){
            
            reversed = reversed * 10;
            
            if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE){
                return 0;
            }
            
            reversed += x % 10;
            x = x /10;
        }
        
        if(isNegetive){
         return (int)(0 - reversed);    
        }
        return (int)reversed;
    }
}