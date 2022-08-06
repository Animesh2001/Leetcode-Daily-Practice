class Solution {
    
    public void permutation(int nums[],List<List<Integer>>ans,List<Integer>list,boolean map[]){
        if(list.size()==nums.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!map[i]){
                list.add(nums[i]);
                map[i]=true;
                permutation(nums,ans,list,map);
                map[i]=false;
                list.remove(list.size()-1);
            }
        }
}
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        boolean map[]=new boolean[nums.length];
        permutation(nums,ans,new ArrayList<Integer>(),map);
        return ans;
        
    }
}