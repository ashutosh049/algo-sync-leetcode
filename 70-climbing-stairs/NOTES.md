##### Test Cases
1
2
3
4
5
6
7
8
9
10
45
​
##### Approach 1: Recursion with memoization
​
```Java
class Solution {
int n;
int[] memo;
public int climbStairs(int n) {
this.n = n;
this.memo = new int[n+1];
return climb(0);
}
private int climb(int i){
if(i > n){
return 0;
}
if(i == n){
return 1;
}
if(memo[i] > 0){
return memo[i];
}
memo[i] = climb(i+1) + climb(i+2);
return memo[i];
}
}
```