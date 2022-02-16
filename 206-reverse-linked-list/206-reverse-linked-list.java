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
    public ListNode reverseList(ListNode curr) {
        
        if(curr == null) 
            return null;
        return reverse(curr, null);
    }
    
    private ListNode reverse(ListNode curr, ListNode next){
        
        if(curr == null){
            return next;
        }
        
        ListNode parent = curr.next;
        curr.next = next;
        
        return reverse(parent, curr);
        
    }
}