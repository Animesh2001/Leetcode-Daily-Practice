class Solution {
    
    public String makeGood(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        while(i<str.length()-1){
            if(Math.abs(str.charAt(i)-str.charAt(i+1))==32){
                    str.deleteCharAt(i);
                    str.deleteCharAt(i);
                    i=0;
                    continue;
            }
            i++;
        }
        return str.toString();
    }
}