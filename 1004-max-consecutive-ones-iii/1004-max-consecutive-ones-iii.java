class Solution {
    public int longestOnes(int[] nums, int k) {
        int acquire = -1;
        int release = -1;
        HashMap<Integer,Integer>map=new HashMap<>();
        int size = 0;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            while(acquire<nums.length-1){
                flag1=true;
                acquire++;
                if(nums[acquire]==0){
                    map.put(0,map.getOrDefault(0,0)+1);
                }
                if(map.getOrDefault(0,0)==k+1){
                    size= Math.max(size,acquire-release-1);
                    break;
                }
                size= Math.max(size,acquire-release);
            }
            while(release<acquire){
                flag2=true;
                release++;
                if(nums[release]==0){
                    map.put(0,map.get(0)-1);
                    break;
                }
            }
            if(flag1==false&&flag2==false){
                break;
            }
        }
        return size;
        
    }
}