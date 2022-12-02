class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())return false;
        
        Map<Character,Integer>fm1=new HashMap<>();
        
        Map<Character,Integer>fm2=new HashMap<>();
        
        Map<Integer,Integer>map=new HashMap<>();
        
        for(int i=0;i<word1.length();i++){
            char ch = word1.charAt(i);
            fm1.put(ch,fm1.getOrDefault(ch,0)+1);
        }
        
        for(int j=0;j<word2.length();j++){
            char ch = word2.charAt(j);
            fm2.put(ch,fm2.getOrDefault(ch,0)+1);
        }
        
        for(Character key : fm1.keySet()){
            if(!fm2.containsKey(key)){
                return false;
            }
        }
        
        for(int val : fm2.values()){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        for(int val : fm1.values()){
            if(map.containsKey(val)){
                int freq = map.get(val);
                if(freq==1){
                    map.remove(val);
                }
                else{
                    map.put(val,freq-1);
                }
            }
        }
        
        return map.size()==0;
         
        
    }
}

//word1 == word2
//word2 == word1