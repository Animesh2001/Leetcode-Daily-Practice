class Solution {
    
      public boolean wordBreaks(String A, List<String> B,HashMap<String,Integer>map)
    {
        //code here
        int size = A.length();
        if(A.length()==0){
            return true;
        }
        
        if(map.containsKey(A))return map.get(A)==1;
        
        for(int k=1;k<=size;k++){
            boolean flag = false;
            String temp= A.substring(0,k);
            for(int j=0;j<B.size();j++){
                if(temp.equals(B.get(j))){
                    flag=true;
                    break;
                }
            }
            if(flag&&wordBreaks(A.substring(k,size),B,map)){
                map.put(A.substring(k,size),1);
                return true;
            }
        }
         map.put(A,-1);
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
         HashMap<String,Integer>map=new HashMap<>();
         return wordBreaks(s,wordDict,map);
    }
}