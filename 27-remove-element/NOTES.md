#### Approach 1: `left` and `right` pointer
​
```java
class Solution {
​
public int removeElement(int[] nums, int val) {
int len = nums.length;
int k = 0;
​
int left = 0;
int right = len - 1;
​
while (left < right) {
while (left < right && nums[left] != val) {
left++;
}
​
while (left < right && nums[right] == val) {
right--;
}
​
int temp = nums[left];
nums[left] = nums[right];
nums[right] = temp;
}
​