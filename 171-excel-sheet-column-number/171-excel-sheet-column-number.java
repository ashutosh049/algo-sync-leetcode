class Solution {
    public int titleToNumber(String s) {
     
        int n = s.length();        
        int pow =  0;
        int decVal = 0;
        
        for(int i = n-1; i >= 0; i--){
            int codePoint = ((int)s.charAt(i)) % 65 +1;
            decVal += (codePoint * Math.pow(26, pow));
            pow++;
        }
        return decVal;
    }
}