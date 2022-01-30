class Solution {
    public int searchInsert(int[] nums, int target) {
     
        int len = nums.length;
        int closestLower = 0;
        int closestHigher = len-1;
        
        int low = 0;
        int high = len-1;
        
        if(target < nums[0]) return 0;
        if(target > nums[len-1]) return len;
        
        while(low <= high){
            int mid = low + ((high-low) >> 2);
            
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                high = mid-1;
                closestHigher = mid;
            }else{
                low = mid+1;
                closestLower = mid;
            }
        }
        
        //return closestLower+1;
        return closestHigher;
        
    }
}