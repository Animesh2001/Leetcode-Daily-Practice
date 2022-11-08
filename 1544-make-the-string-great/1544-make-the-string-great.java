class Solution {
    
    public String makeGood(String s) {
        Stack<Character>stack=new Stack<>();
        stack.push(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--){
            if(!stack.isEmpty()&&Math.abs(stack.peek()-s.charAt(i))==32){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        String str="";
        while(!stack.isEmpty()){
            str+=stack.pop();
        }
        return str;
    }
}