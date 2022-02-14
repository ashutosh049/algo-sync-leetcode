class Solution {
    public boolean isPalindrome(int x) {
        
        int original = x;
        int rev = 0;
        
        if(x < 0)
            return false;
        
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return false;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return false;
            rev = rev * 10 + pop;
        }
        
        return original == rev;
        
    }
}