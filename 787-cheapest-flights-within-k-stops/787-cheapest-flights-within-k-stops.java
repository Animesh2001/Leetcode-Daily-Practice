class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<ArrayList<Integer>>>adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<flights.length;i++){
            int sv = flights[i][0];
            int ev = flights[i][1];
            int price = flights[i][2];
            ArrayList<Integer>tmp=new ArrayList<>();
            tmp.add(ev);
            tmp.add(price);
            adj.get(sv).add(tmp);   
        }
        
        int distance[]=new int[n];
        
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        distance[src]=0;
        
        //construct a queue
       Queue<int[]>queue=new LinkedList<>();
       queue.add(new int[]{src,0});
        int stoppage=0;
        
        while(!queue.isEmpty()&&stoppage<=k){
            int size = queue.size();
            
            while(size>0){
                int pop[]=queue.poll();
                for(ArrayList<Integer>list:adj.get(pop[0])){
                    if(pop[1]+list.get(1)<distance[list.get(0)]){
                        distance[list.get(0)]=pop[1]+list.get(1);
                        queue.add(new int[]{list.get(0),distance[list.get(0)]});
                    }
                }
                size--;
            }
            
            stoppage++;
        }
        
        return distance[dst]==Integer.MAX_VALUE?-1:distance[dst];
        
        
    }
}