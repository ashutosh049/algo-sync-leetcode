public class Solution {

    public boolean hasCycle(ListNode head) {
        boolean hasCycle = false;

        if (head != null) {
            ListNode sp = head;
            ListNode fp = head;

            while (fp.next != null && fp.next.next != null) {
                sp = sp.next;
                fp = fp.next.next;
                
                if (sp == fp) {
                    hasCycle = true;
                    break;
                }

            }
        }

        return hasCycle;
    }
}
