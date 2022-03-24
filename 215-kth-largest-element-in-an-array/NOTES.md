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
int i = 1;
int out = queue.poll();
​
while (i < k) {
out = queue.poll();
i++;
}
​
return out;
}
}
​
​
```
​
#### Approach 3: Minheap of size `k`
​
|Status|Runtime|Memory|Language|
| ---------- |----------|----------|
|Accepted|  2  ms|  42 MB|  java|
​
​
```java
import java.util.Arrays;
import java.util.Collections;
​
class Solution {
​
public int findKthLargest(int[] nums, int k) {
int n = nums.length;
int size = k;
​
if (n == 1) {
return nums[0];
}
​
// Max heap
PriorityQueue<Integer> queue = new PriorityQueue<>(size);
​
int i = 0;
​
// Insert first k elements to make sure heap has at most k elements
for (; i < size; i++) {