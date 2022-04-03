class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode midlleNode = getMiddleNode(head);
        ListNode secondHalfHead = reverse(midlleNode.next);

        //check for palindrom for head and secondHalfHead
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean isPalindrome = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // re-reverse the second half(to revert the changes)
        reverse(midlleNode.next);

        return isPalindrome;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
