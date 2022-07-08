class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int dp[]=new int[nums.length];
        int hash[]=new int[nums.length];
        int lastIndex=0,maxi=1;
        for(int i=0;i<hash.length;i++){
            hash[i]=i;
        }
        
        for(int i=0;i<dp.length;i++){
            dp[i]=1;
        }
        
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0&&dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndex=i;
            }
        }
        
        List<Integer>list=new ArrayList<>();
        list.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        Collections.reverse(list);
        return list;
        
        
        
        
        
    }
}