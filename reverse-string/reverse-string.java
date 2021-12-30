class Solution {
    public void reverseString(char[] s) {
        
        //return reverseWhile(s);
        reverseFor(s);
        
    }

    private void reverseFor(char[] s){
        if(s == null || s.length ==1) return;

        //["h","e","e","l","l","o"]
        int len = s.length-1;
        for(int i=0; i< s.length/2; i++){
            
            char temp = s[i];
            s[i] = s[len-i];
            s[len-i] = temp;
            
        }


    }
    
    private void reverseWhile(char[] s){
        int i=0;
        int j = s.length-1;
        
        if(s == null || s.length ==1) return;
        
        while(i <= j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}