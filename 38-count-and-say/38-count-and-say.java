class Solution {
    
    public String getString(String temp){
        String str = "";
        char initial = temp.charAt(0);
        int count=0;
        for(int i=0;i<temp.length();i++){
            if(temp.charAt(i)==initial){
                count++;
            }else{
                str+=count;
                str+=initial;
                initial=temp.charAt(i);
                count=1;
            }
        }
        str+=count;
        str+=initial;
        return str;
        
    }
    
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        
        String temp = countAndSay(n-1);
        return getString(temp);
    }
}