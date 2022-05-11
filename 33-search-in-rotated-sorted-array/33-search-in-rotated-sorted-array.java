class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1){
            return target==nums[0]?0:-1;
        }
        int ans = findmin(nums);
        int ans1 = search(nums,target,0,ans-1);
        int ans2 = search(nums,target,ans,nums.length-1);
        return ans1==-1?ans2:ans1;
    }
    
     public int findmin(int nums[]){
        int start = 0;
        int end = nums.length-1;
       
       if(nums.length==1){
           return nums[0];
       }
       
       int ans=-1;
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
        return ans;
    }
    
    public int search(int nums[], int target, int start, int end){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    
}