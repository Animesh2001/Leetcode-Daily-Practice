class Solution {
    
    class Pair{
        int sr;
        int sc;
        int val;
        
        public Pair(int sr,int sc,int val){
            this.sr=sr;
            this.sc=sc;
            this.val=val;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean [][]visited=new boolean[image.length][image[0].length];
        int initial = image[sr][sc];
        Queue<Pair>queue=new LinkedList<>();
        queue.add(new Pair(sr,sc,image[sr][sc]));
        visited[sr][sc]=true;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            image[p.sr][p.sc]=color;
            if(p.sr-1>=0&&!visited[p.sr-1][p.sc]&&image[p.sr-1][p.sc]==initial){
                queue.add(new Pair(p.sr-1,p.sc,initial));
                visited[p.sr-1][p.sc]=true;
            }
            if(p.sc-1>=0&&!visited[p.sr][p.sc-1]&&image[p.sr][p.sc-1]==initial){
                queue.add(new Pair(p.sr,p.sc-1,initial));
                visited[p.sr][p.sc-1]=true;
            }
            if(p.sr+1<image.length&&!visited[p.sr+1][p.sc]&&image[p.sr+1][p.sc]==initial){
                queue.add(new Pair(p.sr+1,p.sc,initial));
                visited[p.sr+1][p.sc]=true;
            }
            if(p.sc+1<image[0].length&&!visited[p.sr][p.sc+1]&&image[p.sr][p.sc+1]==initial){
                queue.add(new Pair(p.sr,p.sc+1,initial));
                visited[p.sr][p.sc+1]=true;
            }
        }
        return image;
        
    }
}