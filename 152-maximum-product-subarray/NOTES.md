class Solution {
public int maxProduct(int[] nums) {
int n = nums.length;
int globalMax = nums[0];
int min_sofar = nums[0];
int max_sofar = nums[0];
for(int i=1; i< n; i++){
int curElm = nums[i];
int tempMax = Math.max(curElm, Math.max(min_sofar*curElm, max_sofar*curElm));
min_sofar = Math.min(curElm, Math.min(min_sofar*curElm, max_sofar*curElm));
max_sofar = tempMax;
globalMax = Math.max(max_sofar, globalMax);
}
return globalMax;
}
}