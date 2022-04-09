#### Approach 0: Using `sorting`
​
```java
class Solution {
public int findKthLargest(int[] nums, int k) {
Arrays.sort(nums);
return nums[nums.length-k];
}
}
```
​
TC: `O(NlogN)`
SC: `O(1)`
​
#### Approach 1: Using `MinHeap`
​
1. Create PQ minheap with heapify method
2. Poll for n-k times
3.  return n-k th polled element
​
|Status|Runtime|Memory|Language|
| ---------- |----------|----------|
|Accepted|  11 ms|  45.7 MB|  java|
​
​
##### Code