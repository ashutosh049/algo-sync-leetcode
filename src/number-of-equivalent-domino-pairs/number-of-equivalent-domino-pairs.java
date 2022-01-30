class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        int pairCount = 0;
        //int freq[] = new int[73];
        int[][] freq = new int[10][10];
        
        for(int[] iArr: dominoes){
            int[] domino = sort(iArr);
            int prevCount = freq[domino[0]][domino[1]];
            pairCount += prevCount;
            freq[domino[0]][domino[1]] = prevCount+1;
        }
        
        return pairCount;
        
    }
    
    private int[] sort(int[] arr){
        if(arr[0] < arr[1]){
            return new int[]{arr[0], arr[1]};
        }else if(arr[0] > arr[1]){
            return new int[]{arr[1], arr[0]};
        }
        return arr;
    }
}