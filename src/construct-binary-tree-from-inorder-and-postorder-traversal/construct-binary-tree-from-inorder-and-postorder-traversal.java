/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int postOrderIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postOrderIndex = postorder.length-1;
        return recurse(postorder, inorder, 0, inorder.length - 1);
        
    }
    
    
  private TreeNode recurse(int[] postorder, int[] inorder, int start, int end) {
      if (start > end) return null;
        
      int rootValue = postorder[postOrderIndex--];
      TreeNode root = new TreeNode(rootValue);
      
      int rootIndex = searchElement(inorder, rootValue);
      
      root.right = recurse(postorder, inorder, rootIndex + 1, end);
      
      root.left = recurse(postorder, inorder, start, rootIndex - 1);
      
      return root;
      
    
  }

  private int searchElement(int[] fromArr, int targetElm) {
    if (fromArr != null && fromArr.length >= 1) {
      for (int i = 0; i < fromArr.length; i++) {
        if (targetElm == fromArr[i]) {
          return i;
        }
      }
    }
    return -1;
  }
}