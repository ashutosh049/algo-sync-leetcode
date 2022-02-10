class Solution {

    /** nums [1,2,3,4,5]
    *   k = 9
    * Possible sub-arrays:
    * 1.[1]=1
    * 2.[1,2]=3
    * 3.[1,2,3]=6
    * 4.[1,2,3,4]=10
    * 5.[1,2,3,4,5]=15
    * 6.[2] = 2
    * 7.[2,3] = 5
    * 8.[2,3,4] =9
    * 9.[2,3,4,5] = 14
    * 10.[3] =3
    * 11.[3,4] =7
    * 12.[3,4,5] =12
    * 13.[4] =4
    * 14.[4,5] =9 
    * 15.[5] =5
    * 
    * Output: 1, as there is only 1 sub-array whose sum is 9
    **/
    public int subarraySum(int[] nums, int k) {
        /**int count = 0;
        count = bruteForce_1(nums, k);
        //count = bruteForce_2(nums, k);
        return count; 
        */
        return maxSumSliding(nums,k);
    }
    
    // Brute force-2 (Using 3 for loops)
    // Get all sub-arrays and for each sub-array add all the elements
    // Time-Complexity: O(n^3)
    //  1. For calculating the all the sub-arrrays: O(n^2)
    //  2. For adding all the elements of given sub-array: O(n) 
    // Space-Complexity: O(1). No extra space used
    // Time complexity: O(n^2)
    public int bruteForce_2(int[] nums, int k) {
      
      int count = 0;
      int n = nums.length;
      
      if(n==1 && nums[0] != k){
        return count;
      }
      
      for(int start = 0; start < n; start++){
        for(int end = start+1; end < n; end++){
            int sum = 0;
            for(int i= start; i <= end; i++){
                sum += nums[i];
            }
            if(sum == k){
                count++;
            }
        } 
      }
      return count;
    }
    
    // Brute force-1
    // Use 2 for loops
    // Time complexity: O(n^2)
    public int bruteForce_1(int[] nums, int k) {
      
      int count = 0;
      int n = nums.length;
      
      if(n==1 && nums[0] != k){
        return count;
      }
      
      for(int i=0; i<n; i++){
        int curSum = 0;
        for(int j=i; j<n; j++){
            curSum += nums[j];
            if(curSum == k){
                count++;
            }
        } 
      }
      return count;
    }
    

    
    private static int maxSumSliding(int[] arr, int k) {

    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      int windowSum = 0;
      for (int j = i; j < arr.length; j++) {
        windowSum += arr[j];
          if(windowSum == k)
              count++;
      }
    }
    return count;
  }
}