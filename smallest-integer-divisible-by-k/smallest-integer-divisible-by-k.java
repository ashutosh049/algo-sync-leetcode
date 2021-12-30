class Solution {
//     public int smallestRepunitDivByK(int k) {
        
//         if(k == 1) 
//             return k;
        
        
//         String numStr = "11"; 
        
//         while(numStr.length() <= 10){
//             int num = Integer.valueOf(numStr);
            
//             if(num % k == 0)
//                 return numStr.length();
            
//             numStr += "1";
//         }
        
//         return -1;
        
//     }
    
    public int smallestRepunitDivByK(int K) {
        int remainder = 0;
        for (int length_N = 1; length_N <= K; length_N++) {
            remainder = (remainder * 10 + 1) % K;
            if (remainder == 0) {
                return length_N;
            }
        }
        return -1;
    }
}