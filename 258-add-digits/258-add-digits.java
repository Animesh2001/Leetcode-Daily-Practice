class Solution {
    public int addDigits(int num) {
     
        int sum = 0;
        
        
         while(num/10!=0){
           sum+=num%10;//11+1=12
           num=num/10; //3
             if(num/10==0){
                 sum+=num%10;//8+3=11
                 num=sum;//11
                 sum=0;
             }
         }
        return num;
        
        
        
    }
}