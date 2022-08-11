class Solution {
    
    public int minimumTotal(List<List<Integer>>triangle,int row_ind,int last,int dp[][]){
        if(row_ind>=triangle.size()){
            return Integer.MAX_VALUE;
        }
        if(row_ind==triangle.size()-1){
            return triangle.get(row_ind).get(last);
        }
        if(dp[row_ind][last]!=-1)return dp[row_ind][last];
        int down = minimumTotal(triangle,row_ind+1,last,dp);
        int tedha = minimumTotal(triangle,row_ind+1,last+1,dp);
        return dp[row_ind][last]= triangle.get(row_ind).get(last)+Math.min(down,tedha);
        
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return minimumTotal(triangle,0,0,dp);
    }
}