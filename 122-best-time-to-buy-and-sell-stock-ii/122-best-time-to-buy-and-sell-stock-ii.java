class Solution {
    
    int[] prices;
    
    public int maxProfit(int[] A) {
    
//         int n = prices.length;
        
//         if(n ==1 ){
//             return 0;
//         }
        
//         this.prices = prices;
//         int maxprofit = 0;
//         int buyAt = Integer.MAX_VALUE;
        
//         for(int i=0;i< n; i++){
            
//             buyAt = Math.min(buyAt, prices[i]);
            
//             int currProfit = prices[i] - buyAt; 
            
//             maxprofit = Math.max(maxprofit, currProfit);
             
       
            	

//         }
        
//         return maxprofit;
        
         int n = A.length, lastBuy = -A[0], lastSold = 0;
        if (n == 0) return 0;
                                
        for (int i = 1; i < n; i++) {
            int curBuy = Math.max(lastBuy, lastSold - A[i]);
            int curSold = Math.max(lastSold, lastBuy + A[i]);
            lastBuy = curBuy;
            lastSold = curSold;
        }
        
        return lastSold;
    }
    
    
}