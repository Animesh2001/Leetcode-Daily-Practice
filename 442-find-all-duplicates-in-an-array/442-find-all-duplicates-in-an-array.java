class Solution {
     public void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer>list=new ArrayList<>();
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
            else{
                i++;
            }
        }
        int ans=0;
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                list.add(nums[j]);
            }
        }
        return list;
    }
}