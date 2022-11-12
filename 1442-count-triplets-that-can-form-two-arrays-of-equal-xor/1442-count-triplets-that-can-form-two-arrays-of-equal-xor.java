class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        for(int i=0;i<arr.length-1;i++){
            int ans=0;
            for(int j=i;j<arr.length;j++){
                ans^=arr[j];
                if(ans==0){
                    count+=(j-i);
                }
            }
        }
        return count;
    }
}