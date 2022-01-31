class Solution {
    public int findJudge(int n, int[][] trust) {
        
        if(trust.length == 0){
            if(n == 1){
                return 1;
            }
            return -1;
        }
        
        int[] incoming = new int[n+1];
        int[] outgoing = new int[n+1];
        
        for(int i=0; i < trust.length; i++){
            
            int from = trust[i][0];
            int to = trust[i][1];
            
            outgoing[from]++;
            incoming[to]++;
        }
        
        for(int i=0; i<= n; i++){
            if(incoming[i] == n-1 && outgoing[i] ==0){
                return i;
            }
        }
        
        return -1;
        
    }
}