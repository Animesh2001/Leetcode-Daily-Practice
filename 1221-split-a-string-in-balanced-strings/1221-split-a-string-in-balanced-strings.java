class Solution {
    public int balancedStringSplit(String s) {
        int count_l = 0;
        int count_r = 0;
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L'){
                count_l++;
            }else{
                count_r++;
            }
            if(count_l==count_r){
                ans++;
            }
        }
        return ans;
    }
}