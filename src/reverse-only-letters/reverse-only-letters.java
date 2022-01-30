class Solution {
    public String reverseOnlyLetters(String str) {
        
        char[] s = str.toCharArray();
        
        int i=0;
        int j=s.length-1;
        
            while(i< j && !isLetter(s[i])){
                i++;
            }
            
            while(j >= i && !isLetter(s[j])){
                j--;
            }
        
        while(i <= j){
            
            
            char temp = s[i];
            s[i] = s[j];
            s[j]=temp;
            i++;
            j--;                
            
            while(i< j && !isLetter(s[i])){
                i++;
            }
            
            while(j >= i && !isLetter(s[j])){
                j--;
            }
            
        
        }
        
        return new String(s);
    }
    
    private boolean isLetter(char c){
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}