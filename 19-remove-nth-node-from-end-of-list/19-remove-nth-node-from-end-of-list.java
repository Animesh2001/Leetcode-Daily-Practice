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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        temp=head;
        int ans=count-n;
        if(ans==0)return head.next;
        count=0;
        while(count<ans-1){
            temp=temp.next;
            count++;
        }
        temp.next=temp.next.next;
        return head;
        
    }
}