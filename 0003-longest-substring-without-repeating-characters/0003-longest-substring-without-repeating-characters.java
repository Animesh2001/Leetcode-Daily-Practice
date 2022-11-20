class Solution {
    public int lengthOfLongestSubstring(String s) {
        int acquire  = -1;
        int release = -1;
        HashMap<Character,Integer>map=new HashMap<>();
        char repeating = '\0';
        int size = Integer.MIN_VALUE;
        boolean flag=false;
        while(acquire<s.length()-1){
            
            while(acquire<s.length()-1&&flag==false)
            {
                acquire++;
                char ch = s.charAt(acquire);
                if(map.containsKey(ch)){
                    flag = true;
                    repeating = ch;
                }
                map.put(ch,map.getOrDefault(ch,0)+1);
                size=Math.max(size,map.size());
            }
            
            while(release<acquire&&flag==true){
                release++;
                char ch = s.charAt(release);
                if(ch==repeating){
                    flag=false;
                }
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
            }
            
        }
        return size==Integer.MIN_VALUE?0:size;
    }
}