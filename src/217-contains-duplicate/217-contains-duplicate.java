class Solution {
    public boolean containsDuplicate(int[] nums) {
        
       Set<Integer> set = new HashSet<>();
        
        for(int i: nums){
            set.add(i);
        }
        
        return set.size() % nums.length != 0;
        
    }
    
     public boolean containsDuplicate_II(int[] nums) {
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int n : nums) {
            if(n > max) max = n;
            if(n < min) min = n;
        }
        boolean[] visited = new boolean[max-min+1];
        for(int n : nums) {
            if(visited[max-n]) return true;
            visited[max-n] = true;
        }
        return false;
        
    }
}