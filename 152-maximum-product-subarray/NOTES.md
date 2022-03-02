class Solution {
​
public int maxProduct(int[] nums) {
int n = nums.length;
int maxProduct = nums[0];
int prevMin = nums[0];
int prevMax = nums[0];
​
for (int i = 1; i < n; i++) {
int currMax = Math.max(nums[i], Math.max(prevMin * nums[i], prevMax * nums[i]));
int currMin = Math.min(nums[i], Math.min(prevMin * nums[i], prevMax * nums[i]));
​
prevMin = currMin;
prevMax = currMax;
​
maxProduct = Math.max(prevMax, maxProduct);
}
return maxProduct;
}
}
​
​
##### Approach 2
​