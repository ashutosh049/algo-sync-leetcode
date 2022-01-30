class Solution {
    boolean found;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.found = false;
        
         if(source == destination)
            return  true;
        
        // create visited array
        boolean[] visited = new boolean[n];
        // create adj map
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        
        // init map
        for(int i=0; i<n; i++){
            adjMap.put(i, new ArrayList<Integer>());
        }
        
        for(int[] neighbours: edges){
            adjMap.get(neighbours[0]).add(neighbours[1]);
            adjMap.get(neighbours[1]).add(neighbours[0]);
        }
        
        dfs(adjMap, visited, source, destination);
        
        return found;
        
    }
    
    // Recursive DFS
    private void dfs(Map<Integer, List<Integer>> adjMap, boolean[] visited, int start, int end){
        
        if(visited[start] || found){
            found = true;
            return;
        }
        
        visited[start] = true;
        
        List<Integer> neighbours = adjMap.get(start);
        
        
        for(int v: neighbours){
            if(end == v){
                found = true;
                break;
            }
            
            if(!visited[v]){
                dfs(adjMap, visited, v, end);    
            }
            
        }
        
    }
}