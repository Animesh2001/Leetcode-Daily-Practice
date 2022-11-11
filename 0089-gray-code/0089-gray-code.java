class Solution {
    
    public ArrayList<String> graycode(int n)
    {
        //code here
        if(n==1){
            ArrayList<String>list=new ArrayList<>();
            list.add("0");
            list.add("1");
            return list;
        }
        ArrayList<String>ans=graycode(n-1);
        ArrayList<String>final_ans=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            final_ans.add("0"+ans.get(i));
        }
        for(int i=ans.size()-1;i>=0;i--){
            final_ans.add("1"+ans.get(i));
        }
        return final_ans;
    }
    
    public List<Integer> grayCode(int n) {
        ArrayList<String>list=graycode(n);
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            ans.add(Integer.parseInt(list.get(i),2));
        }
        return ans;
    }
}