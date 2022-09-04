class Solution {
    
    public int distance(int i,int j,int[][]points){
        return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
    }
    
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[2]-b[2]));
        
        pq.add(new int[]{0,0,0});
        
        boolean visited[]=new boolean[points.length];
        int cost=0;
        int count=0;
        while(!pq.isEmpty()&&count<V){
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
// class Solution {
//     public int minCostConnectPoints(int[][] points) {
//         // prims
//         int n = points.length;
//         // make use of a priority queue based on the cost we are going to calculate
//         PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
//         pq.add(new int [] {0, 0, 0});
//         // a boolean array to mark visited
//         boolean [] visited = new boolean [n];
//         int cost = 0;
//         int edges = 0;
//         // we make use of loop that run until the priority queue empty || edges = n-1 
//         while (!pq.isEmpty() || edges < n - 1) {
//             int [] current = pq.remove();
//             if (visited[current[1]])
//                 continue;
//             visited[current[1]] = true;
//             cost += current[2];
//             edges += 1;
//             for (int j = 0; j< n; j++) {
//                 if (!visited[j])
//                     pq.add(new int [] {current[1], j, Math.abs(points[current[1]][0] - points[j][0]) + Math.abs(points[current[1]][1] - points[j][1])});
//             }
//         }
//         return cost;
//     }
// }