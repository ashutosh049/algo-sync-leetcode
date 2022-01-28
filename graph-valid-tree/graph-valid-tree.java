class Solution {
    
    private List<List<Integer>> adjList;
    private Set<Integer> visited;
    
    public boolean validTree(int n, int[][] edges) {
        
        //return iterativeDfSWithSeenSet(n, edges);
        //return iterativeDfSWithSeenMap(n, edges);
        
        // Recursive DFS with seen set
        
        if (edges.length != n - 1) // advanced graph theory
            return false;
        
        this.adjList = new ArrayList<>();
        this.visited = new HashSet<>();
        
        if(edges.length != n-1)
            return false;
        
        for(int i=0; i< n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        //return recursiveDfSWithSeenSet(0, -1) && visited.size() == n;
        return dfs(0, -1) && visited.size() == n;
        
        // Disjoint set
    }
    
    /**
    * Iterative DFS + seen Set
    */
    private boolean iterativeDfSWithSeenSet(int n, int[][] edges) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i< n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> stack = new Stack();
        Set<Integer> visited = new HashSet<>();
        
        stack.push(0);
        visited.add(0);
        
        while(!stack.isEmpty()){
            int curr = stack.pop();
            
            List<Integer> neighbours =  adjList.get(curr);
            
            for(int neighbour: neighbours){
                
                if(visited.contains(neighbour)){
                    return false;
                }
                
                stack.push(neighbour);
                visited.add(neighbour);
                
                adjList.get(neighbour).remove((Integer)curr);
                
            }
        }
        
        return visited.size() == n;
        
    }
    
    /**
    * Iterative DFS + seen Map
    */
    private boolean iterativeDfSWithSeenMap(int n, int[][] edges) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i< n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> parentMap = new HashMap<>();
        
        stack.push(0);
        parentMap.put(0, -1);
        
        while(!stack.isEmpty()){
            int curr = stack.pop();
            
            List<Integer> neighbours =  adjList.get(curr);
            
            for(int neighbour: neighbours){
                
                if(parentMap.get(curr) == neighbour){
                    continue;
                }
                if(parentMap.containsKey(neighbour)){
                    return false;
                }
                
                stack.push(neighbour);
                parentMap.put(neighbour, curr);
            }
        }
        
        return parentMap.size() == n;
        
    }
    
    /**
    * Recursive DFS + seen Set
    */
    private boolean dfs(int curr, int parent) {
        
        if(visited.contains(curr))
            return false;

        visited.add(curr);
        
        for(int neighbour: adjList.get(curr)){
        
            if(neighbour != parent){
                if(!dfs(neighbour, curr)){
                    return false;
                }
            }
            
        }
        
        return true;
    }
}