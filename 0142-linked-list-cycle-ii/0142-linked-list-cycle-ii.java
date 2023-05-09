/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       if(head==null){
            return null;
        }
        ListNode hare=head;
        ListNode tortoise = head;

        boolean ans=false;

        while(hare.next!=null &&hare.next.next!=null){
            hare=hare.next.next;
            tortoise=tortoise.next;

            if(hare==tortoise){
            ans = true;
            break;
            }
            
        }
        if(ans==false){
            return null;
        }
       
        tortoise=head;
         if(hare==tortoise){
            return hare;
        }
        while(hare.next!=tortoise.next){
            hare=hare.next;
            tortoise=tortoise.next;
        }

        return hare.next;
    }
}