class Solution {

    public int[] twoSum(int[] nums, int target) {
        //return naive(nums, target);
        return usingMap(nums, target);
    }

    private int[] naive(int[] nums, int target) {
        int[] sol = new int[2];
        int len = nums.length;

        if (len == 2) {
            // we can directl assign values, as length is only 2
            sol[0] = 0;
            sol[1] = 1;
            return sol;
        }

        //2,7,11,15
        for (int i = 0; i < len; i++) {
            int val1 = nums[i];
            int val2 = target - val1;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == val2) {
                    sol[0] = i;
                    sol[1] = j;
                    break; // assume we have 1 sol only
                }
            }
        }
        return sol;
    }

    // Approach: Map.. target: O(n)

    private int[] usingMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] sol = new int[2];
        int len = nums.length;

        if (len == 2) {
            // we can directl assign values, as length is only 2
            sol[0] = 0;
            sol[1] = 1;
            return sol;
        }

        // add to map
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target-nums[i])){
                sol[0] = i;
                sol[1] = map.get(target - nums[i]);
                break;
            }
        }
        return sol;
    }
}
