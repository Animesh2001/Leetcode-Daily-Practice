class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer>stack=new Stack<>();
        int ans[]=new int[nums.length];
        int n=nums.length;
        for(int i=2*nums.length-1;i>=0;i--){
            while(stack.size()>0&&stack.peek()<=nums[i%n]){
                stack.pop();
            }
            if(stack.size()==0){
                ans[i%n]=-1;
            }else{
                ans[i%n]=stack.peek();
            }
            stack.push(nums[i%n]);
        }
        return ans;
    }
}