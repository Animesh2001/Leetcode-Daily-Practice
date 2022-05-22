class Solution {
    public int balancedStringSplit(String s) {
        char ch = s.charAt(0);
        int count=1,max=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==ch)count++;
            else count--;
            if(count==0)max++;
        }
        return max;
    }
}