class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int len = nums.length;
        
        if(len == 1){
            return nums[0];
        }
        
        Comparator<Integer> comp = (a,b) -> b.compareTo(a);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comp);
        
        for(int num: nums){
            maxHeap.offer(num);
        }
        
        // we need to poll for k-1 times
        // return the next polled element
        int i = 1;
        
        while(i++ < k){
            maxHeap.poll();
        }
        
        return  maxHeap.poll();
        
    }
}