class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int start= 0;
        Arrays.sort(nums);
        recurse(nums, res, new ArrayList<>(),  start);
        return res;
    }
    
    private void recurse(int[] nums, List<List<Integer>> res, List<Integer> tmpList, int start) {
        
        res.add(new ArrayList<>(tmpList));
        
        // check for duplicate
        for(int i=start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;    
            }
            
            tmpList.add(nums[i]);
            recurse(nums, res, tmpList, i+1);
            tmpList.remove(tmpList.size() -1);                

        }
        
    }
}