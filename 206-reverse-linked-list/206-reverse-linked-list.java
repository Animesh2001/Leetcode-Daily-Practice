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
        if(head==null)return head;
        ListNode p1=null,p2=head,p3=head.next;
        while(p2!=null){
            p2.next=p1;
            p1=p2;
            p2=p3;
            if(p3!=null)
            p3=p3.next;
        }
        head=p1;
        return head;
    }
}