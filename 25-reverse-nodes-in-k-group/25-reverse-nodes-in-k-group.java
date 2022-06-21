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
    
    public int length(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode newHead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
    
    public ListNode reverseKGroup(ListNode head,int k,int r,int l){
        if(r>l){
            return head;
        }
        
        ListNode temp=head,secondlist=null;
        for(int i=0;i<k-1;i++){
            temp=temp.next;
        }
        secondlist=temp.next;
        temp.next=null;
        ListNode newHead = reverse(head);
        head.next=reverseKGroup(secondlist,k,r+k,l);
        return newHead;
        
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int l=length(head);
        return reverseKGroup(head,k,k,l);
     }
}