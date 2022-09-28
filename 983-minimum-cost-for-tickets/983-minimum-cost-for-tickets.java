class Solution {
    
    
//find the indexes
    public int find(int days[],int day,int ind){
        int tar=days[ind]+day-1;
        int index = days.length-1;
        for(int j=ind;j<days.length;j++){
            if(days[j]<=tar)index=j;
            else break;
        }
        return index;
    }
    
    public int mincostTickets(int ind,int days[],int costs[],int[]dp){
        if(ind>=days.length){
            return 0;
        }
        
        if(dp[ind]!=-1)return dp[ind];
        
        int one_day = costs[0]+mincostTickets(ind+1,days,costs,dp);
        
        int index = find(days,7,ind);
        int seven_day = costs[1]+mincostTickets(index+1,days,costs,dp);
        
        int index_thirty = find(days,30,ind);
        int thirty_day = costs[2]+mincostTickets(index_thirty+1,days,costs,dp);
        
        return dp[ind]= Math.min(one_day,Math.min(seven_day,thirty_day)); 
    }
    
    
    
    
    
    
    public int mincostTickets(int[] days, int[] costs) {
        int dp[]=new int[days.length];
        Arrays.fill(dp,-1);
        return mincostTickets(0,days,costs,dp);
    }
}