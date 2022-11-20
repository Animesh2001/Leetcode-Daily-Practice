class Solution {

    public String minWindow(String s, String t) {
        int acquire = -1;
        int release = -1;
        
        HashMap<Character,Integer>map1=new HashMap<>();
        HashMap<Character,Integer>map2=new HashMap<>();
        int required = t.length();
        
        for(int i=0;i<t.length();i++){
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }
        
        int count = 0;
        
        String ans = "";
        
        while(acquire<s.length()-1){
            
            while(acquire<s.length()-1&&count<required){
                acquire++;
                char c = s.charAt(acquire);
                map1.put(c,map1.getOrDefault(c,0)+1);
                if(map2.containsKey(c)){
                    if(map1.get(c)<=(map2.get(c))){
                        count++;
                    }
                }
            }
            
            while(release<acquire&&count==required){
                String pans = s.substring(release+1,acquire+1);
                if(ans.length()==0||pans.length()<ans.length()){
                    ans = pans;
                }
                release++;
                char ch = s.charAt(release);
                int f = map1.get(ch);
                if(map2.containsKey(ch)){
                    if(f<=map2.get(ch)){
                        count--;
                    }
                }
                map1.put(ch,f-1);
            }
            
        }
        return ans;
    }
}
