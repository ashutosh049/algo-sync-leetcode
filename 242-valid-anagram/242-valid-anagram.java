class Solution {
    public boolean isAnagram(String s, String t) {
                
        if(s.length() != t.length()){
            return false;
        }
        
        char[] sSorted = s.toCharArray();
        char[] tSorted = t.toCharArray();
        
        Arrays.sort(sSorted);
        Arrays.sort(tSorted);
        
        boolean isAnagram = true;
        
        for(int i=0; i < s.length(); i++){
            if(sSorted[i] != tSorted[i]){
                isAnagram = false;
                break;
            }
        }
        
        return isAnagram;
    }
}