class Solution {
public int maxProfit(int[] prices) {
int n = prices.length;
// 2 loop approach
int maxProfit = 0;
for(int i=0; i< n; i++){
// for each i, i will check remaining price for max profit
int buyAt = prices[i];
for(int j=i+1; j< n; j++){
int sellAt = prices[j];
int newProfit = sellAt - buyAt;
if(maxProfit <  newProfit){
maxProfit = newProfit;
}
}
}
return maxProfit;
}
}