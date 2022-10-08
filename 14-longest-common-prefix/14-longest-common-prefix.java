class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
           prefix =  compare(strs[i],prefix);
        }
        return prefix;
    }
    public String compare(String str,String prefix){
      
        int i=0;
        for(;i<str.length()&&i<prefix.length();){
            if(str.charAt(i)==prefix.charAt(i)){
                i++;
            }else{
                break;
            }
        }
       
        return prefix.substring(0,i);
    }
}