class Solution {
public void combination(int start,int [] candidates,int target,List<Integer>list,List<List<Integer>>ans){
        int n = candidates.length;
        if(target==0){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = start;i<n;i++){
            if(i>start&&candidates[i]==candidates[i-1])continue;
            if(candidates[i]>target)break;
            list.add(candidates[i]);
            combination(i+1,candidates,target-candidates[i],list,ans);
            list.remove(list.size()-1);
        }
        
        
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans=new ArrayList<>();
        combination(0,candidates,target,new ArrayList<Integer>(),ans);
        return ans;
    }
}