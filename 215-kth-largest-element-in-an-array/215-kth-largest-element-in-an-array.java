import java.util.Arrays;
import java.util.Collections;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        //Comparator<Integer> comp = (a, b) ->  b.compareTo(a);
        //PriorityQueue<Integer> queue = new PriorityQueue<>(comp);

        // OR

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b.compareTo(a));

        for (int num : nums) {
            queue.offer(num);
        }

        int i = 1;
        int out = queue.poll();

        while (i < k) {
            out = queue.poll();
            i++;
        }

        return out;
    }
}
