class Solution {
    
    void subsets(int i,int []arr,List<Integer>list,List<List<Integer>>ans,int n){
        if(i>=n){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        list.add(arr[i]);
        subsets(i+1,arr,list,ans,n);
        list.remove(Integer.valueOf(arr[i]));
        subsets(i+1,arr,list,ans,n);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        subsets(0,nums,new ArrayList<Integer>(),ans,nums.length);
        return ans;
    }
}