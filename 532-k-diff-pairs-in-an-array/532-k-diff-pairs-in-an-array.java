class Solution {
    public int findPairs(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for(int i: nums){
            freqMap.put(i, freqMap.getOrDefault(i, 0)+1);
        }
        
        int count = 0;
        
        if(k==0){
            for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
                int key = entry.getKey();
                int value = entry.getValue();
                if(value > 1){
                    count++;
                }
            }    
        }else {
            for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
                int key = entry.getKey();
                int value = entry.getValue();
                if(freqMap.containsKey(key+k)){
                    count++;
                }
            }
        }
        
        return count;


    }
    
}