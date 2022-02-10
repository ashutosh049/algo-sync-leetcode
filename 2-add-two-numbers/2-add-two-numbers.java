class Solution {
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        
        // L1: [9 -> 9 -> 1]
        // L2: [1]
        // L3: [0 -> 0 -> 2] 
        return addNode(node1, node2, 0);
        
    }
    
    ListNode addNode(ListNode node1, ListNode node2, int carry){
        
        if(node1 == null && node2 == null){
            if(carry > 0){
                return new ListNode(carry);                        
            }else {
                return null;
            }
        }
        
        ListNode out = new ListNode(carry);
        
        ListNode nextNode1 = null;
        ListNode nextNode2 = null;
        
        if(node1 != null){
            out.val += node1.val;
            nextNode1 = node1.next;
        }
        if(node2 != null){
            out.val += node2.val;
            nextNode2 = node2.next;
        }
        
        if(out.val > 9){
            int val = out.val;
            out.val = val % 10;
            carry = val / 10;
        }else{
            carry = 0;
        }
        
        out.next = addNode(nextNode1, nextNode2, carry);
        return out;
    }
    
}