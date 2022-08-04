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
         PriorityQueue<Integer>pq=new PriorityQueue<>();
        
        for(int i=0;i<arr.length;i++){
            ListNode start=arr[i];
            while(start!=null){
                pq.add(start.val);
                start=start.next;
            }
        }
        
        ListNode start = null,tail=null;
        
        while(!pq.isEmpty()){
            if(start==null){
                ListNode node = new ListNode(pq.poll());
                start=node;
                tail=node;
            }
            else{
            tail.next=new ListNode(pq.poll());
            tail=tail.next;
            }
        }
        return start;
    }
}