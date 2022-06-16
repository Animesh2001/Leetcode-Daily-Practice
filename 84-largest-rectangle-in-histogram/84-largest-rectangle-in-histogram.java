class Solution {
    
    public static class Pair{
        int num;
        int index;
        public Pair(int num,int index){
            this.num=num;
            this.index=index;
        }
    }
    
    //Function to find largest rectangular area possible in a given histogram.
      public int largestRectangleArea(int[] hist) {
    {
        // your code here
        Stack<Pair>stack=new Stack<>();
        ArrayList<Integer>nsr=new ArrayList<>();
        ArrayList<Integer>nsl=new ArrayList<>();
        
        for(int i=hist.length-1;i>=0;i--){
            if(stack.isEmpty())nsr.add(hist.length);
            else if(stack.peek().num<hist[i])nsr.add(i+1);
            else if(stack.peek().num>=hist[i]){
                while(!stack.isEmpty()&&stack.peek().num>=hist[i]){
                    stack.pop();
                }
                if(stack.isEmpty())nsr.add(hist.length);
                else nsr.add(stack.peek().index);
            }
            stack.push(new Pair(hist[i],i));
        }
        Collections.reverse(nsr);
        
        stack=new Stack<>();
        for(int i=0;i<hist.length;i++){
            if(stack.isEmpty())nsl.add(-1);
            else if(stack.peek().num<hist[i])nsl.add(i-1);
            else if(stack.peek().num>=hist[i]){
                while(!stack.isEmpty()&&stack.peek().num>=hist[i]){
                    stack.pop();
                }
                if(stack.isEmpty())nsl.add(-1);
                else nsl.add(stack.peek().index);
            }
            stack.push(new Pair(hist[i],i));
        }
        int ans=Integer.MIN_VALUE;
        int width[]=new int[hist.length];
        for(int i=0;i<width.length;i++){
            width[i]=(nsr.get(i)-nsl.get(i))-1;
        }
         for(int i=0;i<hist.length;i++){
            ans=Math.max(ans,hist[i]*width[i]);
        }
        return ans;
    }
}
}
    
        
    
