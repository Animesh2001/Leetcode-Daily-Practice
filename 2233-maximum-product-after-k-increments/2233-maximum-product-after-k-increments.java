class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        long M = 1000000007;
        long product=1;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        for(int i=0;i<k;i++){
            int elem = pq.poll();
            elem=elem+1;
            pq.add(elem);
        }
        while(!pq.isEmpty()){
            product=(product*pq.poll())%M;
        }
        return (int)product;
    }
}