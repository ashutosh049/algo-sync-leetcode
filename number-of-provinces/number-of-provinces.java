class Solution {
    boolean[] visited;
    int[][] matrix;
    int N;
    
    public int findCircleNum(int[][] matrix) {
        this.N = matrix.length;
        this.matrix = matrix;
        this.visited = new boolean[N];
        
        int count = 0;
        
        for(int i=0; i<N; i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        
        return count;
    }
    
    private void dfs(int i){
        
        visited[i] = true;
        
        for(int j=0; j<N; j++){
            if(!visited[j] && matrix[i][j]==1){
                dfs(j);
            }
        }
        
    }
}