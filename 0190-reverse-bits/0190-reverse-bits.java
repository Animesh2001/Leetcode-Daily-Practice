public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
            boolean flag = false;
            int j = 0;
            int ans = 0;
            for(int i=31;i>=0;i--){
                int bit_mask = (1<<i);

                if(flag){
                    if((n&bit_mask)!=0){
                       ans+=(1<<j); 
                    }
                    j++;
                }else{
                    if((n&bit_mask)!=0){
                        flag=true;
                        ans+=(1<<j);
                    }
                     j++;
                }

            }
            return ans;
    }
}