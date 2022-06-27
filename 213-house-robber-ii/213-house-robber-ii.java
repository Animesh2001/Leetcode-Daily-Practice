class Solution {
   
    //same code of strivers's lec5
    public int f(int nums[]){
        int prev=nums[0];
        int prev2=0;
        
        for(int i=1;i<nums.length;i++){
            int take = nums[i];
            if(i>1)take+=prev2;
            int nontake = 0+prev;
            int curri=Math.max(take,nontake);
            prev2=prev;
            prev=curri;
        }
        return prev;
        
    }
    
    
    public int rob(int[] nums) {
        int temp1[] = new int[nums.length-1];
        int temp2[] = new int[nums.length-1];
        
        //ALERT= CHECK THIS STEP IF ITS OF SIZE 1
        if(nums.length==1)return nums[0];
        
        
        for(int i=0;i<nums.length;i++){
            if(i!=0)temp1[i-1]=nums[i];
            if(i!=nums.length-1)temp2[i]=nums[i];
        }
        //here only first and last element should not be adjacent
        return Math.max(f(temp1),f(temp2));
        
    }
}