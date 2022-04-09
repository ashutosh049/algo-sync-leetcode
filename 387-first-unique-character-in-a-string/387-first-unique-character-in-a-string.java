class Solution {
    public int firstUniqChar(String s) {
        
        int[] charFreq = new int[26];
        
        for(int i=0; i<s.length(); i++){
            int cp = (int)s.charAt(i);
            cp %= 97;
            charFreq[cp]++;
        }
        
        for(int i=0; i<s.length(); i++){
            int cp = (int)s.charAt(i);
            cp %= 97;
            if(charFreq[cp] == 1){
                return i;
            }
        }
        
        return -1;
        
    }
}