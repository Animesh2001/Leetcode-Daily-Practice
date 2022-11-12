class Solution {
    public int numberOfSteps(int n) {
        if(n==0)return 0;
        int ans = 0;
        
        //if no. is even
        if(n%2==0){
           ans = numberOfSteps(n/2)+1;
        }
        
        //f no. is odd
        if(n%2!=0){
            ans = numberOfSteps(n-1)+1;
        }
        
        return ans;
    }
}