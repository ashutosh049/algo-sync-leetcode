|Accepted|  11 ms|  45.7 MB|  java|
​
​
##### Code
​
```java
import java.util.Arrays;
import java.util.Collections;
​
class Solution {
​
public int findKthLargest(int[] nums, int k) {
int n = nums.length;
​
if (n == 1) {
return nums[0];
}
List<Integer> numList = new ArrayList();
for(int num: nums){
numList.add(num);
}
​
PriorityQueue<Integer> queue = new PriorityQueue(numList);
​
int i = 0;
int kThLargest = queue.poll();
​
while (i < (n - k)) {
kThLargest = queue.poll();
i++;
}
​
return kThLargest;
}
}
​
```
​
---
#### Approach 2 : Using Max Heap(poll for k times)
​
1. Create PQ maxheap (with reverse order comparator)
2. Add all elements to maxheap
3. Poll for k times
4. return Kth polled element
​
|Status|Runtime|Memory|Language|
| ---------- |----------|----------|