# Iterative (using 2 stacks)
​
```
public class Solution {
​
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
ListNode intersectionNode = null;
​
ListNode curr1 = headA;
ListNode curr2 = headB;
​
Deque<ListNode> dq1 = new ArrayDeque<>();
Deque<ListNode> dq2 = new ArrayDeque<>();
​
while (curr1 != null) {
dq1.offerFirst(curr1);
curr1 = curr1.next;
}
​
while (curr2 != null) {
dq2.offerFirst(curr2);
curr2 = curr2.next;
}
​
while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peek() == dq2.peek()) {
intersectionNode = dq1.peek();
dq1.poll();
dq2.poll();
}
​
return intersectionNode;
}
}
​
```