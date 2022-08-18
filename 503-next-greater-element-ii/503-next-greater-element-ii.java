class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer>stack=new Stack<>();
        int ans[]=new int[nums.length];
        int n=nums.length;
        for(int i=2*nums.length-1;i>=0;i--){
            while(stack.size()>0&&stack.peek()<=nums[i%n]){
                stack.pop();
            }
            if(i<n){
            if(stack.size()==0){
                ans[i]=-1;
            }else{
                ans[i]=stack.peek();
            }
            }
            stack.push(nums[i%n]);
        }
        return ans;
    }
}