class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();
        
        int t[][]=new int[n+1][m+1];
        
        //Initializing the matrix
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0)t[i][j]=0;
                if(j==0)t[i][j]=0;
            }
        }
        
        //Fill the rest of the matrix
         for(int i=1;i<n+1;i++){
             for(int j=1;j<m+1;j++){
                //if last two characters of the string are same
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    //call for length n-1 and m-1
                    t[i][j]=1+t[i-1][j-1];
                }
                 else{
                     t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                 }
                
             }
        }
        
        return t[n][m];
        
        
     }
}