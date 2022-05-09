class Solution {
    
    //Explanation
    //1. whenever mid element < high element .. that time our pivot will lie on the left side.. (obviously)
    //2. whenever mid element > high element .. that time our pivot will lie on the right side.. 
    //3. at last the lo==hi break and return the pivot element.
    
    
    public int findMin(int[] nums) {
        int lo =0;
        int hi =nums.length-1;
        
        //we will not consider lo==hi ..consider [1].. here lo==hi.. so in this case lo or hi itself is the pivot element.
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]<nums[hi]){
                //if nums[mid]<nums[hi].. pivot will be on the left
                hi=mid;
            }
            else{
                 //if nums[mid]>nums[hi].. pivot will be on the right
                lo=mid+1;
            }
        }
        
        //at last the loop will break when lo==hi so return anything num[lo] or nums[hi].. it contains the pivot element.!!
        return nums[hi];
    }
}