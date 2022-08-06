class Solution {
    
    public void permutation(int start,int nums[],List<List<Integer>>ans){
        if(start>=nums.length){
            List<Integer>list=new ArrayList<>();
           for(int i:nums)list.add(i);
            ans.add(list);
            return;
        }
        
        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            permutation(start+1,nums,ans);
            swap(nums,i,start);
        }
    }
    
    public void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        permutation(0,nums,ans);
        return ans;
        
    }
}