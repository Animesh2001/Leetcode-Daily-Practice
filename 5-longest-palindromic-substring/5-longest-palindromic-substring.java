class Solution {
    public String longestPalindrome(String str) {
        if(str.length()==1)return str;
        int start=0;
        int end=0;
        
        for(int i=1;i<str.length();i++){
            int low = i-1;
            int high = i;
            
            while(low>=0&&high<str.length()&&str.charAt(low)==str.charAt(high)){
                if(high-low+1>end-start+1){
                    end=high;
                    start=low;
                }
                low--;
                high++;
            }
            
            low=i-1;
            high = i+1;
            while(low>=0&&high<str.length()&&str.charAt(low)==str.charAt(high)){
                if(high-low+1>end-start+1){
                    end=high;
                    start=low;
                }
                low--;
                high++;
            }
        }
        
        return str.substring(start,end+1); 
        
    }
}