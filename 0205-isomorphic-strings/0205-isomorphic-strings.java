class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character>map=new HashMap<>();
        HashMap<Character,Boolean>tn=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(!map.containsKey(ch1)){
                if(tn.containsKey(ch2)){
                    return false;
                }else{
                    map.put(ch1,ch2);
                    tn.put(ch2,true);
                }
            }else{
                if(ch2!=map.get(ch1)){
                    return false;
                }
            }
        }
        return true;
    }
}