class Solution {
    public int missingNumber(int[] nums) {
        int arr[]=new int[nums.length+1];
        
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]=1;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                return i;
            }
        }
        return 0;
    }
}