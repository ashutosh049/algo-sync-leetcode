class Solution {

    public int[] twoSum(int[] nums, int target) {
        //return twoSum_bruteForce(nums, target);
        //return twoSum_2pointer_fail(nums, target);
        return twoSum_optimized(nums, target);
    }
    
    // O(n^2)
    public int[] twoSum_bruteForce(int[] nums, int target) {
        int len = nums.length;

        int[] sol = new int[2];
        
        if (len == 2) {
            sol[0] = 0;
            sol[1] = 1;
        }else{
            for (int i = 0; i < len; i++) {
                int val1 = nums[i];

                for (int j = i + 1; j < len; j++) {
                    if (val1 + nums[j] == target) {
                        // found a sol
                        sol[0] = i;
                        sol[1] = j;
                    }
                }
            }            
        }

        return sol;
    }
    
    // O(n log n)
    public int[] twoSum_2pointer_fail(int[] nums, int target) {
        int len = nums.length;

        int[] sol = new int[2];
        
        if (len == 2) {
            sol[0] = 0;
            sol[1] = 1;
        }else{
            // 1. Sort: O(n*log n)
            // 2. liner scan and use 2 pointer: O(n)
            // Amortized: O(n log n) + o(n) ~ O(n log n)
            
            Arrays.sort(nums);
            
            Arrays.stream(nums)
                .forEach(a -> System.out.print(a+", "));
            
            
            int left = 0;
            int right = len-1;
            
            while(left < right){
                int currSum = nums[left] + nums[right];
                System.out.println("currSum : "+currSum);
                
                if(currSum > target){
                    right--;
                }else if(currSum < target){
                    left++;
                }else{
                    // found a pair
                    sol[0] = left;
                    sol[1] = right;
                    break;
                }
            }
            // not reachable...
            // not founf, return
            
        }

        return sol;
    }
    
    // Counterpart map approach
    // TC: O(n), SC: O(n)
    public int[] twoSum_optimized(int[] nums, int target) {
        int len = nums.length;

        int[] sol = new int[2];
        
        if (len == 2) {
            sol[0] = 0;
            sol[1] = 1;
        }else{
            
            Map<Integer, Integer> counterpartMap = new HashMap<>();
            
            for(int i =0; i < len; i++){
                int val = nums[i];
                int counterpart = target- val;
                if(counterpartMap.containsKey(counterpart)){
                    // found a sol
                     sol[0] = i;
                     sol[1] = counterpartMap.get(counterpart);
                }else{
                    counterpartMap.put(val, i);
                }
            }
            
        }

        return sol;
    }
}
