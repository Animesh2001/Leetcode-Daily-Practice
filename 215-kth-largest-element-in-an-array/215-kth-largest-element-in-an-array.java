class Solution {
    public int findKthLargest(int[] arr, int k) {
        int i=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(;i<k;i++){
            pq.add(arr[i]);
        }
        
        for(;i<arr.length;i++){
            if(arr[i]>pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        
        return pq.peek();
        
    }
}