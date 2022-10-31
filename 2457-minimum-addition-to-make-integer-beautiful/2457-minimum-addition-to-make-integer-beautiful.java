class Solution {
    public long summation(long n){
        long ans=0;
        while(n!=0){
            ans+=n%10;
            n=n/10;
        }
        return ans;
    }
    
    public long makeIntegerBeautiful(long n, int target) {
        long ans = summation(n);
        if(ans<=target){
            return 0;
        }
        
        long ten = 10;
        long answer=0;
        while(summation(n)>target){
            long num = ten-(n%ten);
            answer+=num;
            n+=num;
            ten=ten*10;
        }
        
        return answer;
    }
}