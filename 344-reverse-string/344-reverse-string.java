class Solution {
    public void reverse(char[] s,int i){
        int j = s.length-1;
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
        
    }
    
    public void reverseString(char[] s) {
        reverse(s,0);
    }
}