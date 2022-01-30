class Solution {
    public int findNumbers(int[] nums) {
        
        int count = 0;
        
        for(int i=0; i< nums.length; i++){

            // Using sring.value of method
            //String n = String.valueOf(nums[i]);
            // if(n.length() % 2 == 0){
            //     count++;
            // }
            
            // If strign conversion is not allowed
            int c = 0;
            int n = nums[i];
            while(n > 0){
                n = n/10;
                c++;
            }
            
            if(c %2 ==0){
                count++;
            }
            
       }
    
        return count;
        
    }
}