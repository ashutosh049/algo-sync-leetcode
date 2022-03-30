class Solution {
    public boolean isAnagram(String s, String t) {
                
        int len = s.length();
        boolean isAnagram = true;
        
        if(len != t.length()){
            return false;
        }
        
        
        int[] freS = new int[26];
        int[] freT = new int[26];
        
        for(int i=0; i < len; i++){
            int codePointS = (int) s.charAt(i);
            codePointS = codePointS % 97;
            freS[codePointS]++;
            
            int codePointT = (int) t.charAt(i);
            codePointT = codePointT % 97;
            freT[codePointT]++;
        }
        
        for(int i=0; i < 26; i++){
            if(freS[i] != freT[i]){
                isAnagram = false;
                break;
            }
        }
        
        return isAnagram;
        
    }
}