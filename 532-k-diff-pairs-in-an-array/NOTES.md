##### Approach 1: Trivial brute force - 3 loops and a set
TC: `O(n^2)`
SC: `O(n)`
​
```java
class Solution {
public int findPairs(int[] nums, int k) {
Set<Integer> pairSet = new HashSet<>();// SC: O(n)
int len = nums.length;
if(len == 1)
return 0;
for(int i=0; i<len; i++){ // O(n)
int operand1 = nums[i]; // O(1)
for(int j=i+1; j<len; j++){// O(n)
int operand2 = nums[j];
if(Math.abs(operand1 - operand2) == k){
pairSet.add(operand1 + operand2);
}
}
}
return pairSet.size();