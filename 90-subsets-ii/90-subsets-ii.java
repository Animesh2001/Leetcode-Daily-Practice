class Solution {
    public void subset(int i,int []nums,List<Integer>list,List<List<Integer>>ans){
        int n = nums.length;
        ans.add(new ArrayList<>(list));
         
        for(int start=i;start<n;start++){
            if(start>i&&nums[start]==nums[start-1])continue;
            list.add(nums[start]);
            subset(start+1,nums,list,ans);
            list.remove(list.size()-1);
        }
        return;
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        subset(0,nums,new ArrayList<>(),ans);
        return ans;
    }
}