public class Solution {

    // Brute force: cartesian plane
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersectionNode = null;

        ListNode curr1 = headA;
        ListNode curr2 = headB;

        while (curr1 != null) {
            ListNode temp = curr2;
            while (temp != null) {
                if (temp == curr1) {
                    intersectionNode = curr1;
                    break;
                }
                temp = temp.next;
            }
            
            if(intersectionNode != null){
                break;
            }
            
            curr1 = curr1.next;
        }

        return intersectionNode;
    }
}
