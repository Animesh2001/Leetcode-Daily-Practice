class Solution {
    public void combination(int i,int s,int target,int arr[],List<List<Integer>>ans,List<Integer>list,int n){
        if(i>=n||s>=target){
            if(s==target){
                List<Integer>newList=new ArrayList<>();
                for(int e:list){
                    newList.add(e);
                }
                ans.add(newList);
            }
            return;
        }
        // list=new ArrayList<Integer>();
        if(s+arr[i]<=target){
            list.add(arr[i]);
            s+=arr[i];
            combination(i,s,target,arr,ans,list,n);
            list.remove(Integer.valueOf(arr[i]));
            s-=arr[i];
        }
        
        combination(i+1,s,target,arr,ans,list,n);
       
         
        
        
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        combination(0,0,target,candidates,ans,list,candidates.length);
        return ans;
    }
}