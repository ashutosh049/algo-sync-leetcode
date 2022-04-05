### Approach 1: Using sentinel node and buffuer node
​
```java
class Solution {
​
public ListNode removeElements(ListNode head, int val) {
ListNode sentinel = new ListNode(0);
sentinel.next = head;
​
ListNode prev = sentinel;
ListNode curr = head;
while (curr != null) {
if (curr.val == val) {
prev.next = curr.next;
} else {
prev = curr;
}
curr = curr.next;
}
return sentinel.next;
}
}
​
```