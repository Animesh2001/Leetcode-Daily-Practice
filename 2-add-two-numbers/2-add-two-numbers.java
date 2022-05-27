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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1,t2=l2,temp=null,head=null;
        int carry=0,ans=0;
        
        while(t1!=null&&t2!=null){
        ans=t1.val+t2.val+carry;
        ListNode n = new ListNode(ans%10);
            if(temp==null){
                temp=n;
                head=temp;
            }
        else{
        temp.next=n;
        temp=temp.next;
        }
        carry=ans/10;
        t1=t1.next;
        t2=t2.next;
        }
        
        while(t1!=null){
        ans=t1.val+carry;
        ListNode n = new ListNode(ans%10);
        temp.next=n;
        temp=temp.next;
        carry=ans/10;
        t1=t1.next;
        }
        
        while(t2!=null){
        ans=t2.val+carry;
        ListNode n = new ListNode(ans%10);
        temp.next=n;
        temp=temp.next;
        carry=ans/10;
        t2=t2.next;
        }
        
        if(carry!=0){
            ListNode n = new ListNode(carry);
            temp.next=n;
        }
        return head;
    }
}