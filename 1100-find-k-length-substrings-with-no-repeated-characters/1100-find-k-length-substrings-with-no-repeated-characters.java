class Solution {
    public int numKLenSubstrNoRepeats(String str, int k) {
        
        if(str == null || str.length() == 0 || str.length() < k){
            return 0;
        }
        
        int len = str.length();
        int wStart = 0,wEnd = 0;
        int count=0;
        
        Map<Character, Integer> indexMap = new HashMap<>();
        
        
        for(; wEnd< len; wEnd++){
            char rChar = str.charAt(wEnd);
            
            if(indexMap.containsKey(rChar)){
                wStart = Math.max(wStart, indexMap.get(rChar)+1);
            }
            
            if(wEnd-wStart+1 == k){
                count++;
                wStart++;
            }
            
            indexMap.put(rChar, wEnd);
        }
        return count;
        
    }
}