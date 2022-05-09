class Solution {
    
    public static String helper(int n){
        HashMap<Integer,String>map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        return map.get(n);

    }
    
    public static List<String> subsequences(int digits){
        if(digits==0){
            List<String>list=new ArrayList<>();
            list.add("");
            return list;
        }
        
        List<String>list1=subsequences(digits/10);
        String str = helper(digits%10);
        List<String>ans=new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<str.length();j++){
                String answer=list1.get(i)+str.charAt(j);
                ans.add(answer);
            }
        }
        return ans;
        
    }
    
    
    public List<String> letterCombinations(String digits){
        if(digits.length()==0){
            List<String>list=new ArrayList<>();
            return list;
        }
        int digit=Integer.parseInt(digits);
        return subsequences(digit);
    }
}