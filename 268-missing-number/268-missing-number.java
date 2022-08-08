class Solution {
    
    public void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    public int missingNumber(int[] nums) {
       int i=0;
        while(i<nums.length){
            if(nums[i]>=nums.length){
                i++;
            }
            else if(nums[i]!=nums[nums[i]]){
                swap(nums,i,nums[i]);
            }
            else{
                i++;
            }
        }
        int ans=nums.length;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j){
                ans=j;
                break;
            }
        }
        return ans;
    }
}