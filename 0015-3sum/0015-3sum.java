class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>>res = new ArrayList<>();
        
        int fi = 0;
        
        int n = nums.length;
        
        while(fi<nums.length-2){
            if(fi!=0){
                while(fi<nums.length&&nums[fi]==nums[fi-1]){
                    fi++;
                }
                
                if(fi>=nums.length)break;
            }
            int tar = 0 - nums[fi];
            int si = fi + 1;
            int ei = n - 1;
            
            while(si<ei){
                if(nums[si]+nums[ei]<tar){
                    si++;
                }
                else if(nums[si]+nums[ei]>tar){
                    ei--;
                }
                else{
                    res.add(Arrays.asList(nums[fi],nums[si],nums[ei]));
                    si++;
                    ei--;
                    while(si<ei && nums[si]==nums[si-1])si++;
                    while(si<ei && nums[ei]==nums[ei+1])ei--;
                }
            }
            fi++;
        }
        
        return res;
        
    }
}




//-4 -1 -1 0 1 2