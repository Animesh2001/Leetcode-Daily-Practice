class Solution {
    
    class Pair{
        int value;
        int index;
        
        public Pair(int value,int index){
            this.value=value;
            this.index=index;
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int arr[]=new int[nums.length-k+1];
        
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{return b.value-a.value;});
        
        for(int i=0;i<k;i++){
            pq.add(new Pair(nums[i],i));
        }
        int m=0;
        arr[m++]=pq.peek().value;
        
        for(int j=k;j<nums.length;j++){
            pq.add(new Pair(nums[j],j));
            while(pq.peek().index<=j-k){
                pq.poll();
            }
            arr[m++]=pq.peek().value;
        }
        return arr;
    }
}