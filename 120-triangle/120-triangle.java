class Solution {
    
    public int minimumTotal(List<List<Integer>>triangle,int row_ind,int last,int dp[][]){
        if(row_ind>=triangle.size()){
            return Integer.MAX_VALUE;
        }
        if(row_ind==triangle.size()-1){
            return triangle.get(row_ind).get(last);
        }
        if(dp[row_ind][last]!=-1)return dp[row_ind][last];
        int down = triangle.get(row_ind).get(last)+minimumTotal(triangle,row_ind+1,last,dp);
        int tedha = triangle.get(row_ind).get(last)+minimumTotal(triangle,row_ind+1,last+1,dp);
        return dp[row_ind][last]= Math.min(down,tedha);
        
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][]=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        // for(int rows[]:dp){
        //     Arrays.fill(rows,-1);
        // }
        // return minimumTotal(triangle,0,0,dp);
        
        int row=triangle.size(),col=triangle.get(triangle.size()-1).size();
        for(int i=row-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                if(i==row-1){dp[i][j]=triangle.get(i).get(j);}
                else{
                    dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}