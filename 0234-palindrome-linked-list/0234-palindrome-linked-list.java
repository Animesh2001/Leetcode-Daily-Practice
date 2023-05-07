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
   
            public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
        
    
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newhead = reverseLL(slow.next);
        slow.next=null;
         ListNode temp1 = head, temp2=newhead;
        while(temp1!=null&&temp2!=null){
            if(temp1.val==temp2.val){ 
            temp1=temp1.next;
            temp2=temp2.next;
        }
          else  break;
        }
       if(temp1==null||temp2==null)return true;
        else return false;
        
        
    }
}