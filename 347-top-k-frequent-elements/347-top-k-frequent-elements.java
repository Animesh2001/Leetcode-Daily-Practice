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
       
        
PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{return b.frequency-a.frequency;});
        
        Pair ans[]=new Pair[map.size()];
        
        
        int m = 0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            Pair p = new Pair(entry.getKey(),entry.getValue());
            ans[m++]=p;
        }
        
        for(int i=0;i<ans.length;i++){
            pq.add(ans[i]);
        }
        
        int answer[]=new int[k];
        for(int i=0;i<answer.length;i++){
            answer[i]=pq.poll().value;
        }
        
        return answer;
        
        
        
        
        
        
        
    }
}