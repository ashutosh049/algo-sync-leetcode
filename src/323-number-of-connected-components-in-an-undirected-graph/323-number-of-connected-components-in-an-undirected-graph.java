class Solution {
    public int countComponents(int n, int[][] edges) {
     
        int count = 0;
        List<Integer>[] adjList = new ArrayList[n];
        int[] visited = new int[n];
        
        for(int i=0; i< n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0; i< edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        
        for(int i=0; i< n; i++){
            if(visited[i] == 0){
                count++;
                dfs(i, adjList, visited);
            }
        }
        
        return count;
    }
    
    private void dfs(int i, List<Integer>[] adjList, int[] visited){
        Stack<Integer> stack = new Stack();
        stack.push(i);
        //visited.add(i);
        visited[i] = 1;

        while(!stack.isEmpty()){
            int curr = stack.pop();
            for(int neighbour: adjList[curr]){
                if(visited[neighbour] == 1){
                    continue;
                }
                stack.push(neighbour);
                 visited[neighbour] = 1;
            }            
        }

    }
}