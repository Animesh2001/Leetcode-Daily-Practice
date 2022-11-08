class Solution {
    
    //\U0001f4a1 The logic behind using stack is for every ith charcater we want to check i+1th character and whenever some iterator depends on another iterator there is a possibility that we can optimize this using stack
    //watch first video of stack of Aditya Verma for better understanding of where to use Stack.
    
    public String makeGood(String s) {
        //First create a stack to store the good characters
        Stack<Character>stack=new Stack<>();
        
        for(int i=s.length()-1;i>=0;i--){
            //insert the characters from the last index of the string 
            //\U0001f4a1We are inserting from last because we want to add all the stack characters which is part of good string.. and stack is LIFO so we won't need to reverse the final string..
            
            if(!stack.isEmpty()&&Math.abs(stack.peek()-s.charAt(i))==32){
                //here we first check if stack is not empty and top element of stack difference with current character is 32
                // \U0001f4a1 here we are checking difference as 32 because difference of uppercase and lowercase of same alphabet is 32
                //if it is then we need to pop  as it's making the pair of => eE oe Ee
                stack.pop();
            }else{
                //else if stack is empty or they are not making pairs of eE and Ee
                //then we can simply insert the character where we are standing as it will be the part of our good string \U0001f609
                stack.push(s.charAt(i));
            }
        }
        //at the end stack contains all the characters good string should possess by removing bad pairs.\U0001f929
        
        //created a empty string to store our answer 
        String str="";
        
        //till stack is not empty insert it in the string 
        while(!stack.isEmpty()){
            str+=stack.pop();
        }
        
        //at last return the string.
        return str;
    }
    
}