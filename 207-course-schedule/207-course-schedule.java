class Solution {
    public boolean canFinish(int N, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int []arr:prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }
        
        int V=N;
         int inorder[]=new int[V];
        
        for(int i=0;i<V;i++){
            for(int j:adj.get(i)){
                inorder[j]++;
            }
        }
        
        Queue<Integer>queue=new LinkedList<>();
        
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==0){
                queue.add(i);
            }
        }
        
        int topo[]=new int[V];
        int k=0;
        int count=0;
        while(!queue.isEmpty()){
            int elem = queue.poll();
            topo[k++]=elem;
            count++;
            for(int j:adj.get(elem)){
                inorder[j]--;
                if(inorder[j]==0)queue.add(j);
            }
        }
        
        return count==N;
    }
}