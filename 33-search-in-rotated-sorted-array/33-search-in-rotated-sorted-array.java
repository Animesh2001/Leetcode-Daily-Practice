class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1){
            if(target==nums[0])return 0;
            else return -1;
        }
        int ans = findmin(nums);
        int ans1 = search(nums,target,0,ans-1);
        int ans2 = search(nums,target,ans,nums.length-1);
        return ans1==-1?ans2:ans1;
    }
    
     public boolean check_mid(int arr[],int mid){
        int n=arr.length;
        if(arr[mid]<=arr[(mid+1)%n]&&arr[mid]<=arr[(n+mid-1)%n]){
                return true;
        }
        return false;
    }
    
    public int findmin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            if(check_mid(nums,mid))return mid;
            else if(nums[mid]<nums[end]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return 0;
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