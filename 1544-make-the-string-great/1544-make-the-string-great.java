class Solution {
    
    public boolean uppercase(char ch){
        return ch>=65&&ch<=90;
    }
    
    public boolean lowercase(char ch){
        return ch>=97&&ch<=122;
    }
    
    public String makeGood(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        while(i<str.length()-1){
            if(uppercase(str.charAt(i))&&lowercase(str.charAt(i+1))){
                if(str.charAt(i)-65==str.charAt(i+1)-97){
                    str.deleteCharAt(i);
                    str.deleteCharAt(i);
                    i=0;
                    continue;
                }
            }else if(lowercase(str.charAt(i))&&uppercase(str.charAt(i+1))){
                if(str.charAt(i)-97==str.charAt(i+1)-65){
                    str.deleteCharAt(i);
                    str.deleteCharAt(i);
                    i=0;
                    continue;
                }
            }
            i++;
        }
        return str.toString();
    }
}