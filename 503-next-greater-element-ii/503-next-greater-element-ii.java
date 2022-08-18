class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int arr[]=new int[2*nums.length];
        int i=0;
        for(;i<nums.length;i++){
            arr[i]=nums[i];
        }
        int k=0;
        for(;i<arr.length;i++){
            arr[i]=nums[k++];
        }
        
        int ans[]=new int[2*nums.length];
        Stack<Integer>stack=new Stack<>();
        for(int j=arr.length-1;j>=0;j--){
            while(stack.size()>0&&stack.peek()<=arr[j]){
                stack.pop();
            }
            if(stack.size()==0){
                ans[j]=-1;
            }
            else{
                ans[j]=stack.peek();
            }
            stack.push(arr[j]);
        }
        
        for(int j=0;j<nums.length;j++){
            nums[j]=ans[j];
        }
        return nums;
        
    }
}