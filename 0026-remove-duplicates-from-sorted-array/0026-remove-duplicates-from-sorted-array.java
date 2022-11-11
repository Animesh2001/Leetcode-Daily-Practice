class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = i+1;
        int count=1;
        if(nums.length==2){
            return nums[i]==nums[i-1]?1:2;
        }
        while(i<nums.length&&j<nums.length){
            if(nums[i]==nums[i-1]){
                while(j<nums.length){
                    if(nums[j]>nums[i]){
                        nums[i]=nums[j];
                        count++;
                        i++;
                        j++;
                        break;
                    }
                    j++;
                }
            }else if(nums[i]<nums[i-1]){
                while(j<nums.length){
                    if(nums[j]>nums[i-1]){
                        nums[i]=nums[j];
                        count++;
                        i++;
                        j++;
                        break;
                    }
                    j++;
                }
            }else{
                count++;
                i++;
            }
        }
        return count;
    }
}