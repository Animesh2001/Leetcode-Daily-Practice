class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = nums.length-1;
        while(i>0){
            if(nums[i]==nums[i-1])i-=2;
            else break;
        }
        return nums[i];
        
    }
}