class Solution {
    
    public void combination(int i,int target,int []arr,int size,List<Integer>list,List<List<Integer>>ans){
        if(i>=arr.length){
            if(target==0&&list.size()==size){
                ans.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        if(arr[i]<=target){
            list.add(arr[i]);
            combination(i+1,target-arr[i],arr,size,list,ans);
            list.remove(list.size()-1);
        }
        combination(i+1,target,arr,size,list,ans);
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[]=new int[9];
        for(int i=0;i<9;i++){
            arr[i]=i+1;
        }
        
        List<List<Integer>>ans=new ArrayList<>();
        combination(0,n,arr,k,new ArrayList<Integer>(),ans);
        return ans;
    }
}