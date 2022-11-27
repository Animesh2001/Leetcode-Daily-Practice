class Solution {
    
    public int[] prev_smaller(int arr[]){
        Stack<int[]>stack=new Stack<>();
        int pse[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty()&&stack.peek()[0]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i]=-1;
            }else{
                pse[i]=stack.peek()[1];
            }
            stack.push(new int[]{arr[i],i}); 
        }
        return pse;
    }
    
    public int[] next_smaller(int arr[]){
        Stack<int[]>stack=new Stack<>();
        int nse[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()[0]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i]=arr.length;
            }else{
                nse[i]=stack.peek()[1];
            }
            stack.push(new int[]{arr[i],i}); 
        }
        return nse;
    }
    
    
    
    public int sumSubarrayMins(int[] arr) {
        int pse[] = prev_smaller(arr);
        int nse[] = next_smaller(arr);
        int mod = 1000000000+7;
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            int prev = i-pse[i];
            int next = nse[i]-i;
            long add = (long)(prev * next * (long)arr[i]) % mod;
                ans += add ;
                ans %= mod;
        }
        return ans;
    }
}