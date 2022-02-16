[]
[1]
[1,2]
[1,2,3,4,5]
​
##### Iterative sugin stack
```java
/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode() {}
*     ListNode(int val) { this.val = val; }
*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
* }
*/
class Solution {
public ListNode reverseList(ListNode head) {
if(head == null) return null;
Stack<ListNode> s = new Stack();
while(head != null){
s.push(new ListNode(head.val));
head = head.next;
}
ListNode reversedHead = s.pop();
ListNode curr = reversedHead;
//ListNode pre = null
while(!s.empty()){
curr.next= s.pop();
curr = curr.next;
}
return reversedHead;
}
}
```