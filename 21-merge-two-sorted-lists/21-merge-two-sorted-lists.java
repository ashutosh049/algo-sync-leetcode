/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode curr = sentinel;

        merge(curr, l1, l2);

        return sentinel.next;
    }

    private void merge(ListNode curr, ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                merge(curr.next, l1.next, l2);
            } else {
                curr.next = l2;
                merge(curr.next, l1, l2.next);
            }
        } else {
            if (l1 == null) {
                curr.next = l2;
                return;
            } else {
                curr.next = l1;
                return;
            }
        }
    }
}
