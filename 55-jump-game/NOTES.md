#### Approach 1: Greedy
​
```
class Solution {
public boolean canJump(int[] nums) {
int reach=0;
for(int i=0;i<=reach;i++){
reach = Math.max(reach,i+nums[i]);
if(reach>=nums.length-1) return true;
}
return false;
}
}
```
​
##### Approach 2: Dp (bottom-up recursive with memoiztion)
​
```
class Solution {
int[] nums;
int n;
Boolean[] memo;
public boolean canJump(int[] nums) {
this.nums = nums;
this.n = nums.length;
if(n == 1){
return true;
}
if(nums[0] ==0)