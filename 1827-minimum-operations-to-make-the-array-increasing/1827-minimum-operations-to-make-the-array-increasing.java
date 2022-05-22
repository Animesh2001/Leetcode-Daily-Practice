class Solution {
    public int minOperations(int[] arr) {
        int ans=0,count=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]<0){
                ans = Math.abs(arr[i]-arr[i-1]);
                count+=ans+1;
                arr[i]+=ans+1;
            }else if(arr[i]-arr[i-1]==0){
                arr[i]+=1;
                count+=1;
            }
        }
        return count;
    }
}