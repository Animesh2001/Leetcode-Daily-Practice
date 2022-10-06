class Solution {
    
     public String count_LPS(String str) {
         int n = str.length();
        int lps[]=new int[str.length()];
        int i=1;
        int len = 0;
        while(i<str.length()){
            if(str.charAt(i)==str.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len>0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return str.substring(0,lps[n-1]);
    }
    
    public String longestPrefix(String s) {
        return count_LPS(s);
    }
}