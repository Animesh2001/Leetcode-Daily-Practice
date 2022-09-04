class Solution {
    
    public int findPar(int child,int []parent){
        if(child==parent[child]){
            return child;
        }
        return parent[child]= findPar(parent[child],parent);
    }
    
    public void union(int sv,int ev,int parent[],int rank[]){
        if(rank[sv]<rank[ev]){
            parent[sv]=ev;
        }else if(rank[ev]<rank[sv]){
            parent[ev]=sv;
        }else{
            parent[sv]=ev;
            rank[ev]++;
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        int rank[]=new int[n];
        Arrays.fill(rank,0);
        
        int parent[]=new int[n];
        
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int count=0;
        for(int[]arr:connections){
            int sv = arr[0];
            int ev = arr[1];
            int svp = findPar(sv,parent);
            int evp = findPar(ev,parent);
            if(svp!=evp){
                union(svp,evp,parent,rank);
            }else{
                count++;
            }
        }
        
        int component=0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==i){
                component++;
            }
        }
        
        if(count<component-1){
            return -1;
        }
        
        return component-1;
        
    }
}