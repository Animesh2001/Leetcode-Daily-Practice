class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String>map=new HashMap<>();
        HashMap<String,Boolean>tn = new HashMap<>();
        
        String str[]=s.split(" ");
        
        if(pattern.length()!=str.length)return false;
        
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)){
                if(tn.containsKey(str[i])){
                    return false;
                }
                map.put(ch,str[i]);
                tn.put(str[i],true);
            }else{
                String inmap = map.get(ch);
                if(!inmap.equals(str[i])){
                    return false;
                }
            }
        }
        
        return true;
    }
}