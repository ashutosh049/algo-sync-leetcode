class Solution {
    public String firstPalindrome(String[] words) {
        
        int i=0;
        String firstPalindrom = "";
        while(firstPalindrom == "" && i < words.length){
            if(isPalindrome(words[i])){
                firstPalindrom = words[i];
            }
            i++;
        }
        return firstPalindrom;
    }
    
    private boolean isPalindrome(String s){
        
        int len = s.length();
        int i=  0;
        boolean isPalindrome = true;
        
        while(i < len/2){
            if(s.charAt(i) != s.charAt(len -1 -i)){
                isPalindrome = false;
                break;
            }   
            i++;
        }
        
        return isPalindrome;
        
    }
}