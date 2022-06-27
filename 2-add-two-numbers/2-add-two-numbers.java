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

    public ListNode addTwoNumbers(final ListNode listNode1, final ListNode listNode2) {
        ListNode l1 = listNode1;
        ListNode l2 = listNode2;
        ListNode res = new ListNode();
        int carry = 0;
        ListNode curr = res;

        while (l1 != null || l2 != null) {
            int v1 = (l1 == null ? 0 : l1.val);
            int v2 = (l2 == null ? 0 : l2.val);

            int sum = carry + v1 + v2;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;

            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
            curr = curr.next;
        }

        return res.next;
    }
}
