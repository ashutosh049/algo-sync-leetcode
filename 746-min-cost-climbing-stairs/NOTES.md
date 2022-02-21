##### Approach 1: Bottom-Up iterative
​
```Java
class Solution {
public int minCostClimbingStairs(int[] cost) {
int n = cost.length;
if(n ==2){
return Math.min(cost[0], cost[1]);
}
int memo[] = new int[n+1];
memo[0] = 0;
memo[1] = 0;
for(int i=2; i<= n; i++){
memo[i] = Math.min(memo[i-2]+cost[i-2], memo[i-1]+cost[i-1]);
}
return memo[n];
}
}
```