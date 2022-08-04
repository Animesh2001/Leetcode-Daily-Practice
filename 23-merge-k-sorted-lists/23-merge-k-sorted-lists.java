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
    public ListNode mergeKLists(ListNode[] arr) {
        
        ListNode temp = new ListNode(-1);
        ListNode head=temp;
        
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->{return a.val-b.val;});
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null)
            pq.add(arr[i]);
        }
        
        while(!pq.isEmpty()){
            temp.next=pq.peek();
            temp=temp.next;
            if(pq.peek().next!=null)pq.add(pq.peek().next);
            pq.poll();
        }
        
        return head.next;
    }
}