class Solution {
    public int lastStoneWeight(int[] stones) {
        
        //create a priority queue
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        
        //add all the stones inside priority queue
        for(int i:stones)pq.add(i);
        
        while(pq.size()!=1&&!pq.isEmpty()){
            int firststone = pq.poll();
            int secondstone = pq.poll();
            
            if(firststone!=secondstone){
                pq.add(Math.abs(firststone-secondstone));
            }
        }
        
        return !pq.isEmpty()?pq.peek():0;
        
        
        
        
        
    }
}