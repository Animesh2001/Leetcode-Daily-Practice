class Solution {
    
    public int distance(int i,int j,int[][]points){
        return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
    }
    
    public int minCostConnectPoints(int[][] points) {
        
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[2]-b[2]));
        
        pq.add(new int[]{0,0,0});
        
        boolean visited[]=new boolean[points.length];
        int cost=0;
        int count=0;
        while(!pq.isEmpty()&&count<points.length){
            int arr[]=pq.poll();
            int start = arr[0];
            int end = arr[1];
            int dist = arr[2];
            if(visited[end])continue;
            visited[end]=true;
            cost+=dist;
            count++;
            for(int i=0;i<points.length;i++){
                if(!visited[i]){
                    pq.add(new int[]{end,i,distance(end,i,points)});
                }
            }
        }
        return cost;
        
        
        
        
        
    }
}