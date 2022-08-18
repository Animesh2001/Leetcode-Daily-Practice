class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>stack=new Stack<>();
        int n = nums2.length;
        int ans[]=new int[nums1.length];
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=n-1;i>=0;i--){
            while(stack.size()>0&&stack.peek()<=nums2[i]){
                stack.pop();
            }
            if(stack.size()>0){
                map.put(nums2[i],stack.peek());
            }else{
                map.put(nums2[i],-1);
            }
            stack.push(nums2[i]);
        }
        
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
        
    }
}