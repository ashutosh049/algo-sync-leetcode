class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> map = new HashMap<>();
        		
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 5
            if (map.containsKey(complement)) {
                return new int[] { i, map.get(complement) };
            }else{
                map.put(nums[i], i);
            }
        }
        
        return null;
    }
}