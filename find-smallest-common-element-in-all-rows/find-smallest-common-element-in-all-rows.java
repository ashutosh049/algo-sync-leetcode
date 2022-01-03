class Solution {
    public int smallestCommonElement(int[][] mat) {
        
       //return freqTwoPass(mat);
       return freqSinglePass(mat);
        
    }
    
     public int freqSinglePass(int[][] mat) {
        
        int[] freq = new int[10001];
        int minElm = Integer.MAX_VALUE;
        
        for(int[] rElm: mat){
           for(int cElm: rElm){
               freq[cElm]++;
               if(freq[cElm] == mat.length){
                    minElm = Math.min(minElm, cElm);  
               }
            }   
        }
        
        return minElm == Integer.MAX_VALUE ? -1 : minElm;
        
    }
    
    public int freqTwoPass(int[][] mat) {
        
        int[] freq = new int[10001];
        
        for(int[] rElm: mat){
           for(int cElm: rElm){
               freq[cElm]++;
            }   
        }
        
        
        int minElm = Integer.MAX_VALUE;
        for(int i=1; i< freq.length; i++){
            if(freq[i] == mat.length){
                minElm = Math.min(minElm, i);  
            }
        }
        
        return minElm == Integer.MAX_VALUE ? -1 : minElm;
        
    }
}