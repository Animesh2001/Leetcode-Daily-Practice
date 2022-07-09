class Solution {
    
    public boolean checkPossible(String str1,String str2){
        if(str1.length()!=1+str2.length())return false;
//         int i=0,j=0;
//         int flag=0;
//         while(i<str1.length()&&j<str2.length()){
//             if(str1.charAt(i)==str2.charAt(j)){
//                 i++;
//                 j++;
//             }else{
//                 if(flag==1)return false;
//                 flag=1;
//                 i++;
//             }
//         }
//         if(i<str1.length()){
//             if(flag==0){
//                 return true;
//             }else{
//                 return false;
//             }
//         }
        
//         return true;
        
        int first = 0;
        int second = 0;
        while(first<str1.length()){
            if(second<str2.length()&&str1.charAt(first)==str2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        if(first==str1.length()&&second==str2.length())return true;
        return false;
        
        
        
    }
    
    public int longestStrChain(String[] arr) {
      
       Arrays.sort(arr, Comparator.comparingInt(String::length));
        
        int dp[]=new int[arr.length];
        int n=arr.length;
        int maxi=1;
        for(int i=0;i<dp.length;i++){
            dp[i]=1;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(checkPossible(arr[i],arr[j])&&dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
                maxi=Math.max(maxi,dp[i]);
            }
        }
        return maxi;
    }
}