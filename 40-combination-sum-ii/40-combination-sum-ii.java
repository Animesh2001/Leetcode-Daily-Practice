class Solution {
    
    public void combination(int start,int target,int []arr,List<List<Integer>>ans,List<Integer>list){
        int n = arr.length;
        if(target==0){
                ans.add(new ArrayList<>(list));
            }
        if(start>=n){
            return;
        }
        
        for(int i=start;i<n&&arr[i]<=target;i++){
                if(i==start){
                    list.add(arr[i]);
                    combination(i+1,target-arr[i],arr,ans,list);
                    list.remove(list.size()-1);
                }
            else if(arr[i]!=arr[i-1]){
                    list.add(arr[i]);
                    combination(i+1,target-arr[i],arr,ans,list);
                    list.remove(list.size()-1);
            }
        }
       
    }
    
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans=new ArrayList<>();
        combination(0,target,candidates,ans,new ArrayList<Integer>());
        return ans;
    }
    
}