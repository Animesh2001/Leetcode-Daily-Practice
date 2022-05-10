class Solution {
   public int findMin(int nums[]){
        int start = 0;
        int end = nums.length-1;
       
       if(nums.length==1){
           return nums[0];
       }
        
        while(start<=end){
            int mid = start+(end-start)/2;
            int next = (mid+1)%nums.length;
            int prev = (mid+nums.length-1)%nums.length;
            if(nums[mid]<nums[next]&&nums[mid]<nums[prev]){
                return nums[mid];
            }
            else if(nums[mid]>nums[end]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}