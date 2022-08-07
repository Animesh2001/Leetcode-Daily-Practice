class Solution {
    
    public boolean check_mid(int arr[],int mid){
        int n=arr.length;
        if(arr[mid]<=arr[(mid+1)%n]&&arr[mid]<=arr[(n+mid-1)%n]){
                return true;
        }
        return false;
    }
    
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            if(check_mid(nums,mid))return nums[mid];
            else if(nums[mid]<nums[end]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return 0;
    }
}