import java.util.Arrays;
import java.util.Collections;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int size = k;

        if (n == 1) {
            return nums[0];
        }

        // Max heap
        PriorityQueue<Integer> queue = new PriorityQueue<>(size);

        int i = 0;

        // Insert first k elements to make sure heap has at most k elements
        for (; i < size; i++) {
            queue.offer(nums[i]);
        }

        // for rest of the elements in nums, we need to first poll anf then offer
        for (; i < n; i++) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }

        return queue.poll();
    }
}
