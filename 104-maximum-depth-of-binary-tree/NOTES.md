*
* @param root
* @return
*/
private int maxDepthIterativeBFS(TreeNode root) {
​
List<List<Integer>> resultList = new ArrayList<>();
​
if (root == null) {
return 0;
}
​
TreeNode curr = root;
​
Queue<TreeNode> q = new LinkedList<>();
​
q.offer(curr);
​
while (!q.isEmpty()) {
int qSize = q.size();
List<Integer> subList = new ArrayList<>();
​
for (int i = 0; i < qSize; i++) {
curr = q.poll();
​
subList.add(curr.val);
​
if (curr.left != null) {
q.offer(curr.left);
}
​
if (curr.right != null) {
q.offer(curr.right);
}
}
//add to main list
resultList.add(subList);
​
}
​
return resultList.size();
​
}
​
/**
* Iterative BFS
*
* @param root
* @return
*/
private int maxDepthIterativeBFSEnhanced(TreeNode root) {
​
if (root == null) {
return 0;
}
​