/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.io.Serializable;

public class Codec {

    public String serialize(TreeNode root) {
        return levelOrder(root);
    }

    public TreeNode deserialize(String data) {
        if(data != null && data.trim().length() >= 2){
            String[] nodeArr = data.trim().split(",");
               return buildFromNodes(nodeArr); 
        }
        return null;
    }
    
    private String levelOrder(TreeNode root) {
    
        String orderString = "";
        
        if (root == null) return orderString;

        Queue<Pair<TreeNode, String>> queue = new LinkedList<Pair<TreeNode, String>>();
        queue.add(new Pair<>(root, String.valueOf(root.val)));

        int level = 0;
        while ( !queue.isEmpty() ) {

          int qSize = queue.size();
            
          for(int i = 0; i < qSize; ++i) {
            
            Pair<TreeNode, String> treeNodePair =  queue.remove();
              
            TreeNode node = treeNodePair.getKey();
            String nodeVal = treeNodePair.getValue();
            
            if(nodeVal.charAt(0) == 'l'){
                orderString = appendValue(orderString, "lNull");
            }else if(nodeVal.charAt(0) == 'r'){
                orderString = appendValue(orderString, "rNull");
            }else{
    
                orderString = appendValue(orderString, "#" + node.val);   
            
                if(node.left == null){
                    queue.add(new Pair<>(new TreeNode(), "lNull"));
                }else{
                    queue.add(new Pair<>(node.left, String.valueOf(node.val)));
                }

                if(node.right == null){
                    queue.add(new Pair<>(new TreeNode(), "rNull"));
                }else{
                    queue.add(new Pair<>(node.right, String.valueOf(node.val)));
                }  
            }

            
          }
          level++;
        }
        return orderString;
  }

    
   
    
    //PreOrder String[] :: [#1,#2,lNull,rNull,#3,#4,lNull,rNull,#5,lNull,rNull]
    public TreeNode buildFromNodes(String[] nodes) {

        if (nodes == null || (nodes != null && nodes.length == 0)) {
          return null;
        }

        try {
          int i = 0;

          TreeNode root = new TreeNode(getNodeValue(nodes, i));
          i++;
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root);

          int len = nodes.length;

          while (i < len && !queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr != null) {
              if (i < len) {
                Integer leftVal = getNodeValue(nodes, i);
                if (leftVal != null) {
                  curr.left = new TreeNode(leftVal);
                  queue.offer(curr.left);
                }
                i++;
              }
              if (i < len) {
                Integer rightVal = getNodeValue(nodes, i);
                if (rightVal != null) {
                  curr.right = new TreeNode(rightVal);
                  queue.offer(curr.right);
                }
                i++;
              }
            }
          }
          return root;
        } catch (Exception e) {
          System.err.println(
              "Unable to create Binary Tree Node form provided input nodes:" + Arrays.asList(nodes)
          );
          throw new IllegalArgumentException("Invalid tree structure ::" + Arrays.asList(nodes));
    }

  }
    
    
    // helper method to append given value to order string delimited with comma ','
     private String appendValue(String orderString, String val){
        if(orderString.length() > 0 ){
            orderString += ",";
        }
        return orderString+val;
    }
    
    // helper method to get int value from coded string or null if any
    private Integer getNodeValue(String[] nodes, int i){
        if(i < 0 || nodes == null || (nodes != null && nodes.length == 0))
            return null;
        
        String nodeStringVal = nodes[i];
        
        if(nodeStringVal.charAt(0) == '#'){
            return Integer.valueOf(nodeStringVal.substring(1));    
        }
        
        return null;
            
    }
    

}

class Pair<K, V> implements Serializable {
  private K key;
  private V value;

  public K getKey() {
    return this.key;
  }

  public V getValue() {
    return this.value;
  }

  public Pair(K var1, V var2) {
    this.key = var1;
    this.value = var2;
  }
  
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));