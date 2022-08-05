class Solution {
    public void combination(int i,int target,int []candidates,List<List<Integer>>ans,List<Integer>list){
        int n=candidates.length;
        if(i>=n){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        if(candidates[i]<=target){
            list.add(candidates[i]);
            combination(i,target-candidates[i],candidates,ans,list);
            list.remove(list.size()-1);
        }
        
        combination(i+1,target,candidates,ans,list);
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        
        combination(0,target,candidates,ans,new ArrayList<Integer>());
        return ans;
        
    }
}