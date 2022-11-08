class Solution {
    
    public String makeGood(String s) {
        //First create a stack to store the characters
        Stack<Character>stack=new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
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