class Solution {
    public int compress(char[] chars) {
        int ans = 0,i = 0;
        
        while(i<chars.length){
            char curr= chars[i];
            int count = 0;
            while(i<chars.length&&curr==chars[i]){
                i++;
                count++;
            }
            chars[ans++]=curr;
            if(count>1){
                for(char c : String.valueOf(count).toCharArray()){
                    chars[ans++]=c;
                }
            }
        }
        return ans;
    }
}