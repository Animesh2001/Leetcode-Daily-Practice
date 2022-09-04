class Solution {
    
//     Time Complexity :- O(E*(4alpha));
//     Space Complexity :- O(N);
        
    
    public void union(int sv_parent,int ev_parent,int[]parent,int []rank)
    {
        if(rank[sv_parent]<rank[ev_parent]){
            parent[sv_parent]=ev_parent;
        }else if(rank[ev_parent]<rank[sv_parent]){
            parent[ev_parent]=sv_parent;
        }else{
            parent[sv_parent]=ev_parent;
            rank[ev_parent]++;
        }
    }
    
    public int findPar(int child,int parent[]){
        if(child==parent[child]){
            return child;
        }
        //path compression
        return  parent[child]= findPar(parent[child],parent);
    }
    
    public int findDiscarded(int n,int[][] connections,int []parent){
        int rank[]=new int[n];
        Arrays.fill(rank,0);
        int discarded=0;
        for(int arr[]:connections){
            int starting_vertex = arr[0];
            int ending_vertex = arr[1];
            //O(4alpha)
            int sv_parent = findPar(starting_vertex,parent);
            int ev_parent = findPar(ending_vertex,parent);
            
            //if parents are not same
            if(sv_parent!=ev_parent){
                union(sv_parent,ev_parent,parent,rank);
                //O(1)
            }else{
                discarded++;
            }
        }
        return discarded;
    }
    
    
    
    public int makeConnected(int n, int[][] connections) {
        int parents[]=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        //calculate the no. of wires we had discarded
        int discarded = findDiscarded(n,connections,parents);
        
        int components=0;
        
        //count no. of components
        for(int i=0;i<parents.length;i++){
            if(parents[i]==i){
                components++;
            }
        }
        int required = components-1;
        if(discarded<required)return -1;
        return required;
    }
}