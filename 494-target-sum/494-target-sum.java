class Solution {
    
    public int findTargetSumWays(int[] A, int target,int idx,int sum){
        if(idx==A.length){
            if(target==sum){
             return 1;       
            }
            return 0;
        }
        // int a1=0,a2=0;
       int  a1=findTargetSumWays(A,target,idx+1,sum+A[idx]);
        int a2=findTargetSumWays(A,target,idx+1,sum-A[idx]);
        return a1+a2;
    } 
    public int findTargetSumWays(int[] nums, int target) {
       return findTargetSumWays(nums,target,0,0);
    }
}