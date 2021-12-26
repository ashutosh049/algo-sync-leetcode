import java.util.Arrays;
class Solution {
    
    public TreeNode buildTree(int[] preOrderArr, int[] inOrderArray) {

    int preIndex = 0;
    int currValue = preOrderArr[preIndex];
    preIndex++;

    TreeNode root = new TreeNode(currValue);

    int currValInOrderIndx = searchElement(inOrderArray, currValue);

    int[] inOrderArrLeft = Arrays.copyOfRange(inOrderArray, 0, currValInOrderIndx);
    int[] preOrderArrLeft = Arrays.copyOfRange(preOrderArr, preIndex,
        preIndex + inOrderArrLeft.length);
    if(preOrderArrLeft.length >= 1){
      root.left = buildTree(preOrderArrLeft, inOrderArrLeft);
    }

    preIndex = preIndex + inOrderArrLeft.length;

    int[] inOrderArrRight = Arrays.copyOfRange(inOrderArray, currValInOrderIndx + 1,
        inOrderArray.length);

    int[] preOrderArrRight = Arrays.copyOfRange(preOrderArr, preIndex,
        preIndex + inOrderArrRight.length);

    if(inOrderArrRight.length >= 1){
      root.right = buildTree(preOrderArrRight, inOrderArrRight);
    }

    return root;

  }

  // logn
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