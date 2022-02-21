class Solution {
    public int maxProfit(int[] prices) {
        
        int buyAt = Integer.MAX_VALUE;
        int maxprofit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            
            buyAt = Math.min(buyAt, prices[i]);
            
            int currProfit = prices[i] - buyAt;
            
            maxprofit = Math.max(maxprofit, currProfit);
            
        }
        return maxprofit;
    }
}