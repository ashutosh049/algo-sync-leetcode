#### Approach 1: Iterative using sentinel node
​
```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
ListNode sentinel = new ListNode(-1);
ListNode curr = sentinel;
​
while (l1 != null && l2 != null) {
if (l1.val <= l2.val) {
curr.next = l1;
l1 = l1.next;
} else {
curr.next = l2;
l2 = l2.next;
}
​
curr = curr.next;
}
​
//if there are still some nodes left in l1 or l2
if (l1 == null) {
curr.next = l2;
} else {
curr.next = l1;
}
​