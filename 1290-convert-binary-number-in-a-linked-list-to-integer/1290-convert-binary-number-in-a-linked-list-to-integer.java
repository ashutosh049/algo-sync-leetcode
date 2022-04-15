class Solution {
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            int currVal = head.next.val;
            num = num * 2 + currVal;
            head = head.next;    
        }
        return num;
    }
}