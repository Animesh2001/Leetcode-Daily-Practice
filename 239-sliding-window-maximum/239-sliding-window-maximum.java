class Solution {
    public class Pair{
        int value;
        int index;
        
        public Pair(int val,int ind){
            value=val;
            index=ind;
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Pair>dq=new ArrayDeque<Pair>();
        int ans[]=new int[nums.length-k+1];
        int m=0;
        for(int i=0;i<nums.length;i++){
            
        Pair p =new Pair(nums[i],i);
            
        if(dq.size()>0){
            if(dq.peekFirst().index<=i-k){
                dq.pollFirst();
        }
        }
        
        
        while(dq.size()>0&&dq.peekLast().value<p.value){
            dq.pollLast();
        }
            
        dq.addLast(p);
        
        if(i>=k-1){
            ans[m++]=dq.peekFirst().value;
        }
        }
        return ans;
        
    }
}