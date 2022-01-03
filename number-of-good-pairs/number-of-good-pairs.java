class Solution {
    public int numIdenticalPairs(int[] nums) {
        return naive(nums);   
    }
    
    private int naive(int[] nums) {
        int[] arr = new int[101];
        for(int i = 0;i<nums.length;i++){
            arr[nums[i]] ++;
        }
        int ans = 0;
        for(int i = 0;i<arr.length;i++){
            int count = arr[i];
            ans += count*(count - 1)/2;
        }
        return ans;
    }
    
    
}