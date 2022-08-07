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
    public ListNode reverseList(ListNode head) {
        //recursion
        //base case
        if(head==null||head.next==null)return head;
        
        
        //jadu
        ListNode temp = reverseList(head.next);
        
        head.next.next=head;
        head.next=null;
        
        head=temp;
        
        return head;
        
    }
}