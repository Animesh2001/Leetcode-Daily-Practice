class Solution {
    
    public int[] getnsl(int heights[]){
        Stack<Integer>stack=new Stack<>();
        int nsl[]=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(stack.size()>0&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.size()>0){
                nsl[i]=stack.peek();
            }else{
                nsl[i]=-1;
            }
            stack.push(i);
        }
        return nsl;
    }
    
    
    public int[] getnsr(int[] heights){
        Stack<Integer>stack=new Stack<>();
        int nsr[]=new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            while(stack.size()>0&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.size()>0){
                nsr[i]=stack.peek();
            }else{
                nsr[i]=heights.length;
            }
            stack.push(i);
        }
        return nsr;
    }
    
    public int largestRectangleArea(int[] heights) {
        int nsl[]=getnsl(heights);
        int nsr[]=getnsr(heights);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            maxArea = Math.max(maxArea,heights[i]*(nsr[i]-nsl[i]-1));
        }
        return maxArea;
        
    }
}