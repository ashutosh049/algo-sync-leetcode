class Solution {
    int[] nums;
    int[] memo;
    int[] numsFreq;
    public int deleteAndEarn(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        
        if(n ==1){
            return nums[0];
        }
        Arrays.sort(nums);
        int maxVal = nums[n-1];
        numsFreq = new int[maxVal+1];
        memo = new int[maxVal+1];
        
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        
        
        for(int i=0; i<n; i++){
            int val = nums[i];
            numsFreq[val]++;
        }
        
        return recur(nums[n-1], 0);
        
    }
    
    private int recur(int n, int max){
        
        if(n == 0){
            return n * numsFreq[0];
        }if(n==1){
            return n * numsFreq[1];
        }if(memo[n] != -1){
            return memo[n];
        }
        
       memo[n] = Math.max(recur(n-2, max)+(n * numsFreq[n]), recur(n-1, max));
        
        return memo[n];
        
    }
    
}