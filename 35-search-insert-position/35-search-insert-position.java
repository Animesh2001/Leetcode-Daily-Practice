class Solution {
    public int searchInsert(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int mid = start+(end-start)/2;
        while(start<=end){
            if(arr[mid]==target)return mid;
            else if(arr[mid]>target)end=mid-1;
            else start=mid+1;
            mid = start+(end-start)/2;
        }
        return mid;
    }
}