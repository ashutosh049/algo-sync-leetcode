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
|Accepted|  7 to 14  ms|  44.8 MB|  java|
​
​
```java
​
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
​
//Comparator<Integer> comp = (a, b) ->  b.compareTo(a);
//PriorityQueue<Integer> queue = new PriorityQueue<>(comp);
​
// OR
​
PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b.compareTo(a));
​
for (int num : nums) {
queue.offer(num);
}
​