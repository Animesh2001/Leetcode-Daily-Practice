class Solution {
    public boolean isValid(String x) {
       Stack<Character>stack=new Stack<>();
        int i=0;
        while(i<x.length()){
            if(x.charAt(i)=='{'||x.charAt(i)=='('||x.charAt(i)=='['){
                stack.push(x.charAt(i));
            }else{
                if(!stack.isEmpty()&&x.charAt(i)=='}'&&stack.peek()=='{'){
                    stack.pop();
                }else if(!stack.isEmpty()&&x.charAt(i)==')'&&stack.peek()=='('){
                     stack.pop();
                }else if(!stack.isEmpty()&&x.charAt(i)==']'&&stack.peek()=='['){
                     stack.pop();
                }else{
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
}