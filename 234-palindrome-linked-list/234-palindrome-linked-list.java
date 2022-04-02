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
    public boolean isPalindrome(ListNode head) {
        
        boolean isPalindrom = true;
        
        List<Integer> nodeList = new ArrayList<>();
        
        ListNode curr = head;
        
        while(curr != null){
            nodeList.add(curr.val);
            curr = curr.next;
        }
        
        int left = 0;
        int right = nodeList.size()-1;
        
        while(left < right){
            if(nodeList.get(left) != nodeList.get(right)){
                isPalindrom = false;
                break;
            }
            left++;
            right--;
        }
        
        return isPalindrom;
        
    }
}