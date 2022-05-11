class Solution {
   public int findMin(int nums[]){
        int start = 0;
        int end = nums.length-1;
       
       if(nums.length==1){
           return nums[0];
       }
       
       int ans=0;
       int min=Integer.MAX_VALUE;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            if(min>nums[mid]){
                ans=mid;
                min=nums[mid];
            }
            
            if(nums[mid]>nums[end]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return nums[ans];
    }
}