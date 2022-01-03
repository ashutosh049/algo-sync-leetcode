class Solution {
    public List<Integer> longestCommonSubsequence(int[][] mat) {
        
        int[] freq = new int[101];
        List<Integer> res = new ArrayList<>();
        
        for(int[] rElm: mat){
           for(int cElm: rElm){
               freq[cElm]++;
            }   
        }
        
        
        for(int i=0; i< freq.length; i++){
            if(freq[i] == mat.length){
               res.add(i);                 
            }
        }
        
        return res;
        
    }
}