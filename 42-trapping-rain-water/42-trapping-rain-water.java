class Solution {
    public int trap(int[] height) {
        int ngr[]=new int[height.length];
        ngr[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            ngr[i]=Math.max(height[i],ngr[i+1]);
        }
        int ngl[]=new int[height.length];
        ngl[0]=height[0];
        for(int i=1;i<height.length;i++){
            ngl[i]=Math.max(ngl[i-1],height[i]);
        }
        
        int min[]=new int[height.length];
        for(int i=0;i<height.length;i++){
            min[i]=Math.min(ngr[i],ngl[i]);
        }
        
        int stored_water=0;
        for(int i=0;i<height.length;i++){
            stored_water+=min[i]-height[i];
        }
        return stored_water;
    }
}