class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode curr = root;
        TreeNode res = null;

        while (curr != null) {
            if (curr.val == val) {
                res = curr;
                break;
            } else if (curr.val < val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        return curr;
    }
}
