class Solution {
    public int maximumDetonation(int[][] bombs) {
        int ans = Integer.MIN_VALUE;
        
        for(int i=0;i<bombs.length;i++){
            
            ans = Math.max(ans,getBFS(i,bombs));
        }
        return ans;   
    }
    
    
    public int getBFS(int sv,int [][]bombs){
        boolean visited[]=new boolean[bombs.length];
        visited[sv]=true;
        Queue<Integer>queue=new LinkedList<>();
        queue.add(sv);
        int count=1; //choosed one bomb to detonate
        while(!queue.isEmpty()){
            int pop = queue.poll();
            for(int i=0;i<bombs.length;i++){
                if(!visited[i]&&isRange(i,pop,bombs)){
                        count++;
                    visited[i]=true;
                    queue.add(i);
                    
                }
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