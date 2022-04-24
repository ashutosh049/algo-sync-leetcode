public class Solution {
    public ListNode detectCycle(ListNode head) {

        if(head == null)
            return null;
        
        ListNode sp = head;
        ListNode fp = head;
        
        boolean hasCycle = false;

        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;

            if (sp == fp) {
                hasCycle = true;
                break;
            }

        }
        
        if(hasCycle){
            fp = head;
            
            while(fp.next != null){
                if (sp == fp) {
                    return sp; // or fp
                }
                
                sp = sp.next;
                fp = fp.next;

            }
            
        }
         
        return null;
        
        
    }
}