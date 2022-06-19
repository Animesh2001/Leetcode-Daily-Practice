class Solution {
    
      public int subset(int n,int []arr,int sum){
        int t[][]=new int[n+1][sum+1];
        
        //initialize the matrix
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=1;
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                   if(t[i-1][j-arr[i-1]]!=0||t[i-1][j]!=0){
                       t[i][j]=1;
                   }else{
                       t[i][j]=0;
                   }
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
        
    }
    public boolean canPartition(int[] nums) {
         int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        
        if(sum%2==0){
            return subset(nums.length,nums,sum/2)==1?true:false;
        }
        return false;
    }
}