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
    
    public ListNode middleNode(ListNode head) {
        
        if(head == null) return null;
        
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int i=0;
        
        while(true){
            nodeMap.put(i, head);
            if(head.next == null){
                break;
            }else{
                i++;
                head = head.next;
            }
        }
        
        int mid =  i/2;
        if(i % 2 == 1){
            mid ++;
        }
        //if((mid % 2) == 1) mid++;
        
        return nodeMap.get(mid);
        
    }
}