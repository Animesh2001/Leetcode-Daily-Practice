class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arr[]=new int[nums.length];
        int product=1;
        for(int i=0;i<nums.length;i++){
            arr[i]=product*nums[i];
            product*=nums[i];
        }
        product=1;
        
        for(int j=arr.length-1;j>0;j--){
            arr[j]=product*arr[j-1];
            product*=nums[j];
        }
        arr[0]=product;
        return arr;
    }
}