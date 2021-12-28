class Solution {
    public int minDepth(TreeNode root) {
     
        return minDepthIterativeDFSPostOrder(root);
        
    }
    
    /**
   * Min depth using iterative DFS(post-order)
   */
  private int minDepthIterativeDFSPostOrder(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int minDepth = Integer.MAX_VALUE;
    TreeNode curr = root;
    TreeNode pre = null;
    Stack<TreeNode> s = new Stack();
    int currDepth = 0;

    while (curr != null || !s.isEmpty()) {
      if (curr != null) {
        currDepth += 1; // add node depth
        s.push(curr);
        curr = curr.left;
      } else {

        curr = s.peek();

        if (curr.left == null && curr.right == null) {
          minDepth = Math.min(minDepth, currDepth);
        }

        if (curr.right == null || curr.right == pre) {
          curr = s.pop();
          currDepth -= 1; // revert node depth addition
          pre = curr;
          curr = null;
        } else {
          curr = curr.right;
        }

      }
    }
    return minDepth == Integer.MIN_VALUE ? 0 : minDepth;
  }
}