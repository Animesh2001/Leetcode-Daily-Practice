class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer>map=new HashMap<>();
        
        for(int i=0;i<wall.size();i++){
            int size = 0;
            for(int j=0;j<wall.get(i).size()-1;j++){
                size+=wall.get(i).get(j);
                map.put(size,map.getOrDefault(size,0)+1);
            }
        }
        
       int max = Integer.MIN_VALUE;
        
        for(int val : map.values()){
            if(val>max){
                max=val;
            }
        }
        
        return max==Integer.MIN_VALUE?wall.size():wall.size()-max;
    }
}