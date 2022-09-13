class Solution {
    public int maximumDetonation(int[][] bombs) {
        int ans = Integer.MIN_VALUE;
        
        for(int i=0;i<bombs.length;i++){
            boolean visited[]=new boolean[bombs.length];
            ans = Math.max(ans,getDFS(i,bombs,visited));
        }
        return ans;   
    }
    
    
    public int getDFS(int sv,int [][]bombs,boolean[]visited){
        visited[sv]=true;
        int count = 1;
        
        for(int i=0;i<bombs.length;i++){
            if(!visited[i]&&isRange(i,sv,bombs)){
             visited[i]=true;
             count+=getDFS(i,bombs,visited);
            }
        }
        
        return count;
        
    }
    
    public boolean isRange(int sv,int tv,int[][]bombs){
        long dx1 = bombs[sv][0], dx2 = bombs[tv][0], dy1 = bombs[sv][1], dy2 = bombs[tv][1];
        
        long point1 = (dx1-dx2)*(dx1-dx2);
        long point2 = (dy1-dy2)*(dy1-dy2);
        
        long radius = bombs[tv][2];
        
        return point1+point2<=radius*radius;
        
        
    }
    
}