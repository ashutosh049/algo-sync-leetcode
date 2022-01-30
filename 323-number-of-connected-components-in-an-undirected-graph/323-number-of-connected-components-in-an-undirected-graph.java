class Solution {
    public int countComponents(int n, int[][] edges) {
     
        int count = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        
        for(int i=0; i< n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        
        for(int i=0; i< n; i++){
            if(!visited.contains(i)){
                count++;
                dfs(i, adjList, visited);
            }
        }
        
        return count;
    }
    
    private void dfs(int i, List<List<Integer>> adjList, Set<Integer> visited){
        Stack<Integer> stack = new Stack();
        stack.push(i);
        visited.add(i);
        
        while(!stack.isEmpty()){
            int curr = stack.pop();
            for(int neighbour: adjList.get(curr)){
                if(visited.contains(neighbour)){
                    continue;
                }
                stack.push(neighbour);
                visited.add(neighbour);
            }
        }


    }
}