class Solution {
    
    public int getIndex(ArrayList<Integer>list,int target){
        int start=0;
        int end = list.size()-1;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            
            if(list.get(mid)==target){
                return mid;
            }
            else if(list.get(mid)<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        
        return start;
    }
    
    
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer>list=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(list.size()==0){
                list.add(nums[i]);
            }
            else if(list.get(list.size()-1)<=nums[i]){
                if(list.get(list.size()-1)==nums[i]){
                    continue;
                }else{
                    list.add(nums[i]);
                }
            }
            else{
                int index = getIndex(list,nums[i]);
                list.set(index,nums[i]);
            }
        }
        
        return list.size();
        
    }
}