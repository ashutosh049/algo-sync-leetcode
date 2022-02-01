
class Solution {
    public Node cloneGraph(Node node) {
        
        Map<Node, Node> visited = new HashMap<>();
        
        if(node == null){
            return null;
        }
        
        return dfsRecursive(node, visited);
        
    }
    
     private Node dfsRecursive(Node oNode, Map<Node, Node> visited){
         //base case
         if(visited.containsKey(oNode)){
             return visited.get(oNode);
         }
         
         Node nNode = new Node(oNode.val, new ArrayList());
         visited.put(oNode, nNode);
         
         //For all the neighbors of old-node, create new nodes
         for(Node oNeighbor: oNode.neighbors){
             Node nNeighbor = dfsRecursive(oNeighbor, visited);
             nNode.neighbors.add(nNeighbor);
         }
         
         return nNode;
     }

}
    
    
    
    
    
    