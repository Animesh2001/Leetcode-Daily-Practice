class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }
        int rmsb = (xor & -xor);
        int num1 = 0;
        int num2 = 0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&rmsb)>0)
                num1=num1^nums[i];
            else
                num2=num2^nums[i];  
        }
        return new int[]{num1,num2};
    }
}