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
    
    public ListNode reverseKGroup(ListNode head, int k,int length){
        if(head==null)return null;
        if(length-k<0){
            return head;
        }
        int count=0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while(curr!=null&&count<k){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null)
            next=next.next;
            count++;
        }
        ListNode newhead = prev;
        ListNode ans = reverseKGroup(curr,k,length-k);
        head.next=ans;
        return newhead;
        
        
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int length = 0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return reverseKGroup(head,k,length);
    }
}