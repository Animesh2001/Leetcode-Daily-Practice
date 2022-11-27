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
    public ListNode removeNodes(ListNode head) {
        if (head == null){
            return null;
        }
        
        head.next = removeNodes(head.next);
        
        if(head.next==null){
            return head;
        }
        
        if(head.next.val>head.val){
            return head.next;
        }
        
        return head;
    }
}