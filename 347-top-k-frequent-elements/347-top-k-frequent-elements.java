class Solution {
    
    public class Pair{
        int value;
        int frequency;
        
        public Pair(int value,int frequency){
            this.value=value;
            this.frequency=frequency;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer>map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
       
        
PriorityQueue<Map.Entry<Integer,Integer>>pq=new PriorityQueue<>((a,b)->{return b.getValue()-a.getValue();});
        
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            pq.add(entry);
        }
        
        int ans[]=new int[k];
        
        for(int i=0;i<ans.length;i++){
            ans[i]=pq.poll().getKey();
        }
        
        return ans;
        
        
        
        
        
        
        
    }
}